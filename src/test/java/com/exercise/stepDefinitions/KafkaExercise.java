package com.exercise.stepDefinitions;

import com.exercise.kafka.SampleConsumer;
import com.exercise.kafka.SampleProducer;
import com.exercise.utils.DBUtils;
import com.exercise.utils.MessageMapping;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KafkaExercise {

    Logger logger = LoggerFactory.getLogger(KafkaExercise.class);

    SampleProducer producer = new SampleProducer();
    SampleConsumer consumer = new SampleConsumer();
    DBUtils dbUtils = new DBUtils();
    ArrayList<String> sampleMessage = new ArrayList<>();
    ExecutorService executorService = Executors.newFixedThreadPool(5);

    int currentRowCount;

    public KafkaExercise() throws SQLException {
    }


    @Given("^consumer is running to process the data in topic (.+)$")
    public void consumer_is_running_to_process_the_data_in_topic(String topic) throws Throwable {
        Runnable consumerThread = new Runnable() {
            @Override
            public void run() {
                consumer.consumeAndPersist(topic);
            }
        };
        executorService.execute(consumerThread);
    }

    @When("^user publish the message on producer in (.+) topic$")
    public void user_publish_the_message_on_producer_in_topic(String topic) throws Throwable {

        long id = new Random().nextLong();
        String msgKey = UUID.randomUUID().toString();
        String message = UUID.randomUUID().toString();

        producer.produce(msgKey, topic, id, message);
        Thread.sleep(5000);
        sampleMessage.add(String.valueOf(id));
        sampleMessage.add(message);
        logger.info("sampleMessageList: " + sampleMessage);
    }

    @Given("^message should be stored in table (.+) correctly$")
    public void message_should_be_stored_in_table_correctly(String tableName) throws Throwable {

        ResultSet resultSet = dbUtils.selectPostGresTable(tableName, "id", sampleMessage.get(0));
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getString(1) + "Message: " + resultSet.getString(2));
            Assert.assertEquals("ID is matching: ", sampleMessage.get(0), resultSet.getString(1));
            Assert.assertEquals("Message value is matching: ", sampleMessage.get(1), resultSet.getString(2));
        }

    }

    @And("^count the no of rows in the table (.+)$")
    public void count_the_no_of_rows_in_the_table(String tableName) throws Throwable {

        currentRowCount = dbUtils.countPostGresTable(tableName);
        logger.info("Initial Row Count: " + currentRowCount);

    }

    @Then("^row count of the table (.+) should match with the updated row count$")
    public void row_count_of_the_table_should_match_with_the_updated_row_count(String tableName) throws Throwable {

        int updatedRowCount = dbUtils.countPostGresTable(tableName);
        logger.info("Update Row Count: " + updatedRowCount);

        Assert.assertEquals("Updated row count is matching.", currentRowCount + 1, updatedRowCount);

    }

    @Then("^message should arrive in kafka$")
    public void message_should_arrive_in_kafka() throws Throwable {

        MessageMapping msgMapping = MessageMapping.getInstance();
        logger.info("Producer Key: " + msgMapping.getProducerKey() + "Consumer Key: " + msgMapping.getProducerKey());

        Assert.assertTrue(msgMapping.getProducerKey() != null && msgMapping.getConsumerKey() != null &&
                msgMapping.getProducerKey().equals(msgMapping.getConsumerKey()));
    }

    @Then("^duplicate record should not present in the table (.+)$")
    public void duplicate_record_should_not_present_in_the_table(String tableName) throws Throwable {

        int distinctRowCount = dbUtils.countDuplicateRecord(tableName, sampleMessage.get(0));
        logger.info("Row Count: " + distinctRowCount);

        Assert.assertEquals("Row count is should not more than 1. ", 1, distinctRowCount);
    }

}
