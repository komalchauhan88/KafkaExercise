package com.exercise.app;

import com.exercise.kafka.SampleProducer;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Random;

public class ProducerApp {

    public static void main(String[] args) throws JsonProcessingException {
        SampleProducer producer =new SampleProducer();
        producer.produce("test","kafka_exercise",new Random().nextLong(),"Komal");
    }
}
