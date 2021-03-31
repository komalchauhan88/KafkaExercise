package com.exercise.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.*;

public class DBUtils extends ConnGetter {

    Logger logger = LoggerFactory.getLogger(DBUtils.class);

    public DBUtils() throws SQLException {
    }

    public ResultSet selectPostGresTable(String tableName, String keyName, String value) throws Throwable {

        String query = "SELECT * FROM" + " " + tableName + " " + "WHERE" + " " + keyName + "=" + "'" + value + "'";
        logger.info("Inside Select command and the query is: " + query);
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(query);

        return result;
    }

    public Integer countPostGresTable(String tableName) throws Throwable {
        int numberOfRows = 0;
        String query = "SELECT COUNT(*) FROM " + tableName;
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(query);

        if (result.next()) {
            numberOfRows = result.getInt(1);
            logger.info("Number of Rows = " + numberOfRows);
        } else {
            logger.error("Error: could not get the record counts");
        }
        return numberOfRows;
    }

    public Integer countDuplicateRecord(String tableName, String value) throws Throwable {
        int numberOfRows = 0;
        String query = "SELECT COUNT(*) FROM " + tableName + " where id= " + "'" + value + "'";

        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(query);

        if (result.next()) {
            numberOfRows = result.getInt(1);
            logger.info("Number of Rows = " + numberOfRows);
        } else {
            logger.error("Error: could not get the record counts");
        }
        return numberOfRows;
    }
}
