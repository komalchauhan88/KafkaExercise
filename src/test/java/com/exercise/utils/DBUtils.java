/**
 * Method to perform DDL action in database
 *
 * @author Komal Kumar
 */

package com.exercise.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DBUtils extends ConnGetter {

    Logger logger = LoggerFactory.getLogger(DBUtils.class);

    public DBUtils() throws SQLException {
    }

    /**
     * Method to query the data from table using the condition
     *
     * @param tableName - Table name to be query
     * @param keyName   - Name os the column name on which putting the condition
     * @param value     - Value of the column name 'keyName'
     */
    public ResultSet selectPostGresTable(String tableName, String keyName, String value) throws Throwable {

        String query = "SELECT * FROM" + " " + tableName + " " + "WHERE" + " " + keyName + "=" + "'" + value + "'";
        logger.info("Inside Select command and the query is: " + query);
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(query);

        return result;
    }

    /**
     * Method to get the row count of the table
     *
     * @param tableName - Table name to be query
     */
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

    /**
     * Method to get the row count of the table on condition
     *
     * @param tableName - Table name to be query
     * @param value     - Value of the column key 'id'
     */
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
