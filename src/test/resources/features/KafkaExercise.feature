Feature: Verify the end to end of flow of Producer and Consumer service in Kafka and validate the data against database.

  @E2E @ProducerConsumerMsgKeyValidation
  Scenario Outline: Verify the data has been published and saved correctly in database.
    Given consumer is running to process the data in topic <topicName>
    When user publish the message on producer in <topicName> topic
    Then message should arrive in kafka
    Examples:
      | topicName       |
      | devTesTask90POE |

  @E2E @DataValidation
  Scenario Outline: Verify the data has been published and saved correctly in database.
    Given consumer is running to process the data in topic <topicName>
    When user publish the message on producer in <topicName> topic
    Then message should be stored in table <tableName> correctly

    Examples:
      | topicName       | tableName |
      | devTesTask90POE | exercise  |

  @E2E @RowCount
  Scenario Outline: Verify the data count in the database table
    Given consumer is running to process the data in topic <topicName>
    And count the no of rows in the table <tableName>
    When user publish the message on producer in <topicName> topic
    Then row count of the table <tableName> should match with the updated row count

    Examples:
      | topicName       | tableName |
      | devTesTask90POE | exercise  |

  @E2E @DuplicateRecord
  Scenario Outline: Verify that duplicate record are present in the database table
    Given consumer is running to process the data in topic <topicName>
    When user publish the message on producer in <topicName> topic
    Then duplicate record should not present in the table <tableName>

    Examples:
      | topicName       | tableName |
      | devTesTask90POE | exercise  |