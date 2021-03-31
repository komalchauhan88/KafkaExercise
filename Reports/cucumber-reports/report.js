$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("KafkaExercise.feature");
formatter.feature({
  "line": 1,
  "name": "Verify the end to end of flow of Producer and Consumer service in Kafka and validate the data against database.",
  "description": "",
  "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Verify the data has been published and saved correctly in database.",
  "description": "",
  "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.;verify-the-data-has-been-published-and-saved-correctly-in-database.",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@E2E"
    },
    {
      "line": 3,
      "name": "@ProducerConsumerMsgKeyValidation"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "consumer is running to process the data in topic \u003ctopicName\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user publish the message on producer in \u003ctopicName\u003e topic",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "message should arrive in kafka",
  "keyword": "Then "
});
formatter.examples({
  "line": 8,
  "name": "",
  "description": "",
  "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.;verify-the-data-has-been-published-and-saved-correctly-in-database.;",
  "rows": [
    {
      "cells": [
        "topicName"
      ],
      "line": 9,
      "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.;verify-the-data-has-been-published-and-saved-correctly-in-database.;;1"
    },
    {
      "cells": [
        "devTesTask90POE"
      ],
      "line": 10,
      "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.;verify-the-data-has-been-published-and-saved-correctly-in-database.;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 10,
  "name": "Verify the data has been published and saved correctly in database.",
  "description": "",
  "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.;verify-the-data-has-been-published-and-saved-correctly-in-database.;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@E2E"
    },
    {
      "line": 3,
      "name": "@ProducerConsumerMsgKeyValidation"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "consumer is running to process the data in topic devTesTask90POE",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user publish the message on producer in devTesTask90POE topic",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "message should arrive in kafka",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "devTesTask90POE",
      "offset": 49
    }
  ],
  "location": "KafkaExercise.consumer_is_running_to_process_the_data_in_topic(String)"
});
formatter.result({
  "duration": 1668912529,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "devTesTask90POE",
      "offset": 40
    }
  ],
  "location": "KafkaExercise.user_publish_the_message_on_producer_in_topic(String)"
});
formatter.result({
  "duration": 7867256228,
  "status": "passed"
});
formatter.match({
  "location": "KafkaExercise.message_should_arrive_in_kafka()"
});
formatter.result({
  "duration": 4532069,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 13,
  "name": "Verify the data has been published and saved correctly in database.",
  "description": "",
  "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.;verify-the-data-has-been-published-and-saved-correctly-in-database.",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 12,
      "name": "@E2E"
    },
    {
      "line": 12,
      "name": "@DataValidation"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "consumer is running to process the data in topic \u003ctopicName\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "user publish the message on producer in \u003ctopicName\u003e topic",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "message should be stored in table \u003ctableName\u003e correctly",
  "keyword": "Then "
});
formatter.examples({
  "line": 18,
  "name": "",
  "description": "",
  "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.;verify-the-data-has-been-published-and-saved-correctly-in-database.;",
  "rows": [
    {
      "cells": [
        "topicName",
        "tableName"
      ],
      "line": 19,
      "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.;verify-the-data-has-been-published-and-saved-correctly-in-database.;;1"
    },
    {
      "cells": [
        "devTesTask90POE",
        "exercise"
      ],
      "line": 20,
      "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.;verify-the-data-has-been-published-and-saved-correctly-in-database.;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 20,
  "name": "Verify the data has been published and saved correctly in database.",
  "description": "",
  "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.;verify-the-data-has-been-published-and-saved-correctly-in-database.;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 12,
      "name": "@E2E"
    },
    {
      "line": 12,
      "name": "@DataValidation"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "consumer is running to process the data in topic devTesTask90POE",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "user publish the message on producer in devTesTask90POE topic",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "message should be stored in table exercise correctly",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "devTesTask90POE",
      "offset": 49
    }
  ],
  "location": "KafkaExercise.consumer_is_running_to_process_the_data_in_topic(String)"
});
formatter.result({
  "duration": 25542211,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "devTesTask90POE",
      "offset": 40
    }
  ],
  "location": "KafkaExercise.user_publish_the_message_on_producer_in_topic(String)"
});
formatter.result({
  "duration": 5068119640,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "exercise",
      "offset": 34
    }
  ],
  "location": "KafkaExercise.message_should_be_stored_in_table_correctly(String)"
});
formatter.result({
  "duration": 16653685,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 23,
  "name": "Verify the data count in the database table",
  "description": "",
  "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.;verify-the-data-count-in-the-database-table",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@E2E"
    },
    {
      "line": 22,
      "name": "@RowCount"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "consumer is running to process the data in topic \u003ctopicName\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "count the no of rows in the table \u003ctableName\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "user publish the message on producer in \u003ctopicName\u003e topic",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "row count of the table \u003ctableName\u003e should match with the updated row count",
  "keyword": "Then "
});
formatter.examples({
  "line": 29,
  "name": "",
  "description": "",
  "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.;verify-the-data-count-in-the-database-table;",
  "rows": [
    {
      "cells": [
        "topicName",
        "tableName"
      ],
      "line": 30,
      "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.;verify-the-data-count-in-the-database-table;;1"
    },
    {
      "cells": [
        "devTesTask90POE",
        "exercise"
      ],
      "line": 31,
      "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.;verify-the-data-count-in-the-database-table;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 31,
  "name": "Verify the data count in the database table",
  "description": "",
  "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.;verify-the-data-count-in-the-database-table;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@RowCount"
    },
    {
      "line": 22,
      "name": "@E2E"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "consumer is running to process the data in topic devTesTask90POE",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "count the no of rows in the table exercise",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "user publish the message on producer in devTesTask90POE topic",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "row count of the table exercise should match with the updated row count",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "devTesTask90POE",
      "offset": 49
    }
  ],
  "location": "KafkaExercise.consumer_is_running_to_process_the_data_in_topic(String)"
});
formatter.result({
  "duration": 21304356,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "exercise",
      "offset": 34
    }
  ],
  "location": "KafkaExercise.count_the_no_of_rows_in_the_table(String)"
});
formatter.result({
  "duration": 3974590,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "devTesTask90POE",
      "offset": 40
    }
  ],
  "location": "KafkaExercise.user_publish_the_message_on_producer_in_topic(String)"
});
formatter.result({
  "duration": 5031878130,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "exercise",
      "offset": 23
    }
  ],
  "location": "KafkaExercise.row_count_of_the_table_should_match_with_the_updated_row_count(String)"
});
formatter.result({
  "duration": 1048300,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 34,
  "name": "Verify that duplicate record are present in the database table",
  "description": "",
  "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.;verify-that-duplicate-record-are-present-in-the-database-table",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 33,
      "name": "@E2E"
    },
    {
      "line": 33,
      "name": "@DuplicateRecord"
    }
  ]
});
formatter.step({
  "line": 35,
  "name": "consumer is running to process the data in topic \u003ctopicName\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 36,
  "name": "user publish the message on producer in \u003ctopicName\u003e topic",
  "keyword": "When "
});
formatter.step({
  "line": 37,
  "name": "duplicate record should not present in the table \u003ctableName\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 39,
  "name": "",
  "description": "",
  "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.;verify-that-duplicate-record-are-present-in-the-database-table;",
  "rows": [
    {
      "cells": [
        "topicName",
        "tableName"
      ],
      "line": 40,
      "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.;verify-that-duplicate-record-are-present-in-the-database-table;;1"
    },
    {
      "cells": [
        "devTesTask90POE",
        "exercise"
      ],
      "line": 41,
      "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.;verify-that-duplicate-record-are-present-in-the-database-table;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 41,
  "name": "Verify that duplicate record are present in the database table",
  "description": "",
  "id": "verify-the-end-to-end-of-flow-of-producer-and-consumer-service-in-kafka-and-validate-the-data-against-database.;verify-that-duplicate-record-are-present-in-the-database-table;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 33,
      "name": "@DuplicateRecord"
    },
    {
      "line": 33,
      "name": "@E2E"
    }
  ]
});
formatter.step({
  "line": 35,
  "name": "consumer is running to process the data in topic devTesTask90POE",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 36,
  "name": "user publish the message on producer in devTesTask90POE topic",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 37,
  "name": "duplicate record should not present in the table exercise",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "devTesTask90POE",
      "offset": 49
    }
  ],
  "location": "KafkaExercise.consumer_is_running_to_process_the_data_in_topic(String)"
});
formatter.result({
  "duration": 27095602,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "devTesTask90POE",
      "offset": 40
    }
  ],
  "location": "KafkaExercise.user_publish_the_message_on_producer_in_topic(String)"
});
formatter.result({
  "duration": 5038019194,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "exercise",
      "offset": 49
    }
  ],
  "location": "KafkaExercise.duplicate_record_should_not_present_in_the_table(String)"
});
formatter.result({
  "duration": 1466879,
  "status": "passed"
});
});