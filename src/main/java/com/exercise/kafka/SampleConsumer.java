package com.exercise.kafka;

import com.exercise.entities.SampleMessage;
import com.exercise.utils.ConnGetter;
import com.exercise.utils.EnvConfig;
import com.exercise.utils.MessageMapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class SampleConsumer {

    Logger logger = LoggerFactory.getLogger(SampleConsumer.class);

    Properties props = new Properties();
    ObjectMapper objectMapper = new ObjectMapper();
    ConnGetter connGetter = new ConnGetter();
    MessageMapping msgMapping = MessageMapping.getInstance();

    public SampleConsumer() throws SQLException {
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, EnvConfig.configValues("key_deserializer_class_config"));
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, EnvConfig.configValues("value_deserializer_class_config"));
        props.put(ConsumerConfig.GROUP_ID_CONFIG, EnvConfig.configValues("group_id_config"));
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, EnvConfig.configValues("auto_offset_reset_config"));
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, EnvConfig.configValues("bootstrap_servers_config"));
    }

    public void consumeAndPersist(String topic) {
        final Consumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList(topic));

        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10));
                for (ConsumerRecord<String, String> record : records) {
                    String key = record.key();
                    msgMapping.setConsumerKey(key);
                    SampleMessage value = objectMapper.readValue(record.value(), SampleMessage.class);
                    logger.info("Consumed record with key %s and value %s \n", key, value);
                    writeToDb(value.getId(), value.getMessage());
                }
            }
        } catch (JsonProcessingException e) {
            logger.error("Exception occurred:" + e);
        } finally {
            consumer.close();
        }
    }

    public void writeToDb(long id, String msg) {

        String insertStmt = "INSERT INTO exercise (id,message) VALUES(?,?)";
        try (PreparedStatement st = connGetter.con.prepareStatement(insertStmt)) {
            st.setLong(1, id);
            st.setString(2, msg);
            st.execute();
            logger.info("Msg persisted in db");
        } catch (SQLException ex) {
            logger.error("Exception occurred: " + ex);
        }

    }


}
