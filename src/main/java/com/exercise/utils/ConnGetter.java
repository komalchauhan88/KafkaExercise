package com.exercise.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnGetter {

    String url = EnvConfig.configValues("postgresqlConnect");
    String user = EnvConfig.configValues("username");
    String password = EnvConfig.configValues("password");

    public Connection con = DriverManager.getConnection(url, user, password);

    public ConnGetter() throws SQLException {
    }
}
