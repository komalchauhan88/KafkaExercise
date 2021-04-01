package com.exercise.utils;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

public class EnvConfig {

    @SneakyThrows
    public static String configValues(String key) {

        Properties prop = new Properties();
        FileInputStream inputFileStream = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//applicationConfig.properties");
        prop.load(inputFileStream);

        return prop.getProperty(key);
    }
}
