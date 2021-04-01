package com.exercise.utils;

import lombok.Data;

@Data
public class MessageMapping {
    private static MessageMapping INSTANCE;
    private String producerKey;
    private String consumerKey;

    private MessageMapping() {
    }

    public static MessageMapping getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MessageMapping();
        }
        return INSTANCE;
    }

}
