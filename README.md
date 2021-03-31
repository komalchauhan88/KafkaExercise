# Kafka-Exercise-SDET

Kafka-Exercise-SDET project is written in Java language that create a messaging system build on Kafka in which a producer publishes the message in the format of {id, message} and consumer read it. Message is persisted in the PostGres DB in 'exercise' table in 'test_db' database. Secondly, to verify the communication, BDD test framework is written that verify the completeness and correctness of the message flow from producer to consumer and then DB. Kafka system and test framework is dockerized suing the docker-composer.

## Tools Used:

[Java](https://choosealicense.com/licenses/mit/)   
[Kafka](https://www.confluent.io/)  
[Docker](https://www.docker.com/)  
[Docker-Compose](https://github.com/docker/compose)  
[Postgres](https://www.postgresql.org/)  
[Maven](https://mvnrepository.com/)  
[Cucumber](https://cucumber.io/docs/bdd/)  
[Gherkin](https://cucumber.io/docs/gherkin/reference/)  
[JUnit](https://junit.org/junit5/) 


## Installation and Execution

Clone the github repository. 
```bash
$ git clone git@github.com:komalchauhan88/KafkaExercise.git
```
Update the maven project to download/update the maven dependencies.
```bash
$ mvn clean compile install
```
Run the launchTestEnv.sh file that will invoke the docker-compose.yml file in detach mode.  
```bash
$ ./launchTestEnv.sh 
```

It will start the container of Zookeeper, Kafka, schema-registry, Postgres and Maven.  Verify the container by using the following command:
```bash
$ docker ps --format '{{.Names}}' 

schema-registry  
bdd  
kafka0  
zookeeper  
pg_container
```  

BDD Container will start the test scenario execution in the feature file and publish the Cucumber Pretty report in a folder 'Reports'. Verify the BDD execution logs by using the following command:
```bash
$ docker logs bdd -f
```

Once all BDD execution is completed, run the following command to stop the container and clean up the images and mounts.
```bash
$ ./stopAndCleanUpTestEnv.sh
```

## Reporting

Cucumber Pretty report will be generated in the 'Reports' folder in json and html format. 

```text
$ ls Reports/Cucumber.json
$ ls Reports/cucumber-reports/index.html
```

## BDD Execution Report Screenshot

![Alt text](KafkaExerciseExecutionScreenshot.png?raw=true "Cucumber Execution Report")
