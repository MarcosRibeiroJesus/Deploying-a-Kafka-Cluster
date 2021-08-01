## Deploying-a-Kafka-Cluster


### To run the examples:
Install Java (Oracle/OpenJDK) JDK 11 and Setup Gradle (grade wrapper) 

- docker-compose up
- ./gradlew :module4:run -PmainClass='kafka.CreateTopic'
- ./gradlew :module4:run -PmainClass='kafka.Consume' --args "dispatch-service"
- ./gradlew :module3:run -PmainClass='kafka.Produce'
- ./gradlew :module4:run -PmainClass='kafka.ConsumeAndFail' --args "dispatch-service"
