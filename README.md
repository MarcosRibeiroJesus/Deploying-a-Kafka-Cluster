# Deploying-a-Kafka-Cluster
## To run the examples:
Install Java (Oracle/OpenJDK) JDK 11 and Setup Gradle (gradle wrapper)

docker-compose up
- ./gradlew :module5:run -PmainClass='kafka.CreateTopic'
> [main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka version: 2.4.1            <br>
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka commitId: c57222ae8cd7866b <br>
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka startTimeMs: 1627859874140 <br>
Topics in the cluster: <br>
quote-feedback <br>

- ./gradlew :module5:run -PmainClass='kafka.DescribeTopics'
> Topic quote-feedback                            <br>
 Partition: 0 <br>
   Leader: localhost:9092 (id: 1002 rack: null) <br>
   Replicas: <br>
     - localhost:9092 (id: 1002 rack: null) <br>
     - localhost:9091 (id: 1001 rack: null) <br>
     - localhost:9093 (id: 1003 rack: null) <br>
 Partition: 1 <br>
   Leader: localhost:9091 (id: 1001 rack: null) <br>
   Replicas: <br>
     - localhost:9091 (id: 1001 rack: null) <br>
     - localhost:9093 (id: 1003 rack: null) <br>
     - localhost:9092 (id: 1002 rack: null) <br>

- ./gradlew :module5:run -PmainClass='kafka.Produce'
> [kafka-producer-network-thread | producer-1] INFO org.apache.kafka.clients.Metadata - [Producer clientId=producer-1] Cluster ID: MdV6O-DXT6uD-P5UroCZHg                    <br>         
 <br>
Value with key 12334 assigned to partition: 0 <br>
Value with key 12335 assigned to partition: 1 <br>
Value with key 12334 assigned to partition: 0 <br>
 <br>
[main] INFO org.apache.kafka.clients.producer.KafkaProducer - [Producer clientId=producer-1] Closing the Kafka producer with timeoutMillis = 9223372036854775807 ms. <br>
 <br>
BUILD SUCCESSFUL in 1s <br>
3 actionable tasks: 1 executed, 2 up-to-date <br>
- ./gradlew :module5:run -PmainClass='kafka.ConsumeAndFail' --args "dispatch-service"

## To check Kafka logs:
docker-compose logs kafka1 | (**Select-String** on Windows or **grep** on Unix) "insync"
> kafka1_1     |  min.insync.replicas = 1                                                                                                                                                          <br>
kafka1_1     |  min.insync.replicas = 1 <br>
kafka1_1     | [2021-08-01 23:17:54,764] INFO Created log for partition quote-feedback-1 in /var/lib/kafka/data/quote-feedback-1 with properties {min.insync.replicas=2} (kafka.log.LogManager) <br>
kafka1_1     | [2021-08-01 23:17:54,805] INFO Created log for partition quote-feedback-0 in /var/lib/kafka/data/quote-feedback-0 with properties {min.insync.replicas=2} (kafka.log.LogManager) <br>