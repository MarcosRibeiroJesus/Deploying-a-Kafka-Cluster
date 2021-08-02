# Deploying-a-Kafka-Cluster
## To run the examples:
Install Java (Oracle/OpenJDK) JDK 11 and Setup Gradle (gradle wrapper)

- docker-compose up -d
- ./gradlew :module6:generateProto
- ./gradlew :module6:run -PmainClass='kafka.CreateTopic'
> [main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka version: 5.5.0-ccs            <br>
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka commitId: 785a156634af5f7e <br>
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka startTimeMs: 1627865057120 <br>
Topics in the cluster: <br>
trip-intent <br>

- ./gradlew :module6:run -PmainClass='kafka.ProtobufBasicConsumer'
> Trip from '48.2026,16.3688' to '48.1869,16.3133' requested.  <br>

- ./gradlew :module6:run -PmainClass='kafka.ProtobufBasicProducer'
> [main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka version: 5.5.0-ccs <br>
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka commitId: 785a156634af5f7e <br>
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka startTimeMs: 1627865488657 <br>
[kafka-producer-network-thread | producer-1] INFO org.apache.kafka.clients.Metadata - [Producer clientId=producer-1] Cluster ID: Hj4BHnYaS1OKS6N2r-3jTA <br><br>
BUILD SUCCESSFUL in 1s <br>
6 actionable tasks: 1 executed, 5 up-to-date <br>

- ./gradlew :module6:run -PmainClass='kafka.ProtobufDynamicConsumer'
> Pickup location: 48.2026,16.3688

- ./gradlew :module6:run -PmainClass='kafka.ProtobufProducer'
## To check Kafka logs:
docker-compose logs kafka1 | (**Select-String** on Windows or **grep** on Unix) "insync"