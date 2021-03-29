package com.exercise.app;

import com.exercise.kafka.SampleConsumer;

public class ConsumerApp {
    public static void main(String[] args) {
        SampleConsumer consumer = new SampleConsumer();
        consumer.consumeAndPersist("kafka_exercise");
    }
}
