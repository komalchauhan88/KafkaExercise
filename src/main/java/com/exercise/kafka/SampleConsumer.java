package com.exercise.kafka;


import com.exercise.entities.SampleMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.*;


import java.sql.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class SampleConsumer {
    Properties props = new Properties();
    ObjectMapper objectMapper=new ObjectMapper();

    String url = "jdbc:postgresql://localhost:5432/test_db";
    String user = "root";
    String password = "root";
    String stmt=" Insert into exercise (id,message) values(?,?)";

    public SampleConsumer(){
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-consumer-1");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    }


    public void consumeAndPersist(String topic){
        final Consumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList(topic));

        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10));
                for (ConsumerRecord<String, String> record : records) {
                    String key = record.key();
                    SampleMessage value = objectMapper.readValue(record.value(), SampleMessage.class);
                    System.out.printf("Consumed record with key %s and value %s \n", key, value);
                    writeToDb(value.getId(),value.getMessage());
                }
            }
        } catch (JsonProcessingException e) {
            System.err.println("Execption occurred:"+e);
        }  finally {
            consumer.close();
        }
    }




    public  void writeToDb(long id,String msg){

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement st = con.prepareStatement(stmt)) {
            st.setLong(1,id);
            st.setString(2,msg);
            st.execute();
            System.out.println("Msg persisited in db");
        } catch (SQLException ex) {
            System.err.println("Execption occuurred: "+ex);
        }
    }


}
