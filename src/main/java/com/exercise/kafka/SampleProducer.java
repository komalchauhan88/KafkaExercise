/**
 * Contains method for Producer
 *
 * @author Komal Kumar
 */

package com.exercise.kafka;

import com.exercise.entities.SampleMessage;
import com.exercise.utils.EnvConfig;
import com.exercise.utils.MessageMapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class SampleProducer {

    Logger logger = LoggerFactory.getLogger(SampleProducer.class);

    Properties props = new Properties();
    ObjectMapper objectMapper = new ObjectMapper();
    MessageMapping msgMapping = MessageMapping.getInstance();

    public SampleProducer() {

        props.put(ProducerConfig.ACKS_CONFIG, EnvConfig.configValues("acks_connfig"));
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, EnvConfig.configValues("bootstrap_servers_config"));
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, EnvConfig.configValues("key_serializer_class_config"));
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, EnvConfig.configValues("value_serializer_class_config"));
    }

    /**
     * Method to publish the message on the topic
     * @param msgKey - Message Key generated by producer associate with every message
     * @param topic - Topic name
     * @param id - Message ID
     * @param msg - Message string
     */
    public void produce(String msgKey, String topic, long id, String msg) throws JsonProcessingException {

        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        producer.send(new ProducerRecord<String, String>(topic, msgKey, objectMapper.writeValueAsString(new SampleMessage(id, msg))),
                new Callback() {
                    public void onCompletion(RecordMetadata m, Exception e) {
                        if (e != null) {
                            e.printStackTrace();
                        } else {
                            logger.info("Produced record to topic %s partition [%d] @ offset %d%n", m.topic(), m.partition(), m.offset());
                        }
                    }
                });
        msgMapping.setProducerKey(msgKey);
        producer.flush();
        producer.close();

    }
}
