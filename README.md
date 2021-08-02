# Deploying-a-Kafka-Cluster
## To run the examples:
Install Java (Oracle/OpenJDK) JDK 11 and Setup Gradle (gradle wrapper)

- docker-compose up -d
- ./gradlew :module8:run -PmainClass='kafka.CreateTopic'
> Topics in the cluster: <br>
_confluent-controlcenter-6-2-0-1-KSTREAM-OUTERTHIS-0000000105-store-repartition <br>
_confluent-controlcenter-6-2-0-1-group-aggregate-store-THREE_HOURS-repartition <br>
_confluent-controlcenter-6-2-0-1-group-aggregate-store-THREE_HOURS-changelog <br>
_confluent-controlcenter-6-2-0-1-MonitoringVerifierStore-repartition <br>
_confluent-controlcenter-6-2-0-1-aggregate-topic-partition-store-repartition <br>
trip-intent <br>
_confluent-controlcenter-6-2-0-1-KSTREAM-OUTEROTHER-0000000106-store-repartition <br>
_confluent-controlcenter-6-2-0-1-aggregate-topic-partition-store-changelog <br>
_confluent-controlcenter-6-2-0-1-monitoring-message-rekey-store <br>
_confluent-controlcenter-6-2-0-1-cluster-rekey <br>
_confluent-metrics <br>
_confluent-controlcenter-6-2-0-1-MonitoringMessageAggregatorWindows-ONE_MINUTE-changelog <br>
_confluent-controlcenter-6-2-0-1-aggregatedTopicPartitionTableWindows-ONE_MINUTE-changelog <br>
_confluent-controlcenter-6-2-0-1-AlertHistoryStore-changelog <br>
_confluent-controlcenter-6-2-0-1-MonitoringTriggerStore-changelog <br>
_confluent-controlcenter-6-2-0-1-MonitoringVerifierStore-changelog <br>
_confluent-controlcenter-6-2-0-1-MonitoringMessageAggregatorWindows-THREE_HOURS-changelog <br>
_confluent-controlcenter-6-2-0-1-aggregatedTopicPartitionTableWindows-THREE_HOURS-repartition <br>
_confluent-command <br>
_confluent-controlcenter-6-2-0-1-expected-group-consumption-rekey <br>
_confluent-controlcenter-6-2-0-1-monitoring-trigger-event-rekey <br>
_confluent-controlcenter-6-2-0-1-AlertHistoryStore-repartition <br>
_confluent-controlcenter-6-2-0-1-MonitoringStream-ONE_MINUTE-repartition <br>
_confluent-controlcenter-6-2-0-1-Group-ONE_MINUTE-repartition <br>
_confluent-controlcenter-6-2-0-1-actual-group-consumption-rekey <br>
_confluent-controlcenter-6-2-0-1-MonitoringTriggerStore-repartition <br>
_confluent-controlcenter-6-2-0-1-TriggerActionsStore-repartition <br>
_confluent-controlcenter-6-2-0-1-KSTREAM-OUTERTHIS-0000000105-store-changelog <br>
_confluent-controlcenter-6-2-0-1-KSTREAM-OUTEROTHER-0000000106-store-changelog <br>
_confluent-controlcenter-6-2-0-1-TriggerEventsStore-repartition <br>
_confluent-controlcenter-6-2-0-1-MonitoringStream-ONE_MINUTE-changelog <br>
_confluent-controlcenter-6-2-0-1-group-stream-extension-rekey <br>
_confluent-controlcenter-6-2-0-1-MonitoringMessageAggregatorWindows-THREE_HOURS-repartition <br>
_confluent-controlcenter-6-2-0-1-aggregatedTopicPartitionTableWindows-ONE_MINUTE-repartition <br>
_confluent-controlcenter-6-2-0-1-metrics-trigger-measurement-rekey <br>
_confluent-controlcenter-6-2-0-1-MonitoringStream-THREE_HOURS-repartition <br>
_schemas <br>
_confluent-controlcenter-6-2-0-1-Group-THREE_HOURS-changelog <br>
_confluent-controlcenter-6-2-0-1-monitoring-aggregate-rekey-store-changelog <br>
_confluent-controlcenter-6-2-0-1-group-aggregate-store-ONE_MINUTE-repartition <br>
_confluent-controlcenter-6-2-0-1-MonitoringMessageAggregatorWindows-ONE_MINUTE-repartition <br>
_confluent-controlcenter-6-2-0-1-TriggerEventsStore-changelog <br>
_confluent-controlcenter-6-2-0-1-group-aggregate-store-ONE_MINUTE-changelog <br>
_confluent-controlcenter-6-2-0-1-aggregatedTopicPartitionTableWindows-THREE_HOURS-changelog <br>
_confluent-controlcenter-6-2-0-1-TriggerActionsStore-changelog <br>
_confluent-controlcenter-6-2-0-1-Group-THREE_HOURS-repartition <br>
_confluent-controlcenter-6-2-0-1-monitoring-aggregate-rekey-store-repartition <br>
_confluent-controlcenter-6-2-0-1-Group-ONE_MINUTE-changelog <br>
_confluent-controlcenter-6-2-0-1-MetricsAggregateStore-changelog <br>
_confluent-monitoring <br>
_confluent-controlcenter-6-2-0-1-MetricsAggregateStore-repartition <br>
_confluent-controlcenter-6-2-0-1-MonitoringStream-THREE_HOURS-changelog <br>


BUILD SUCCESSFUL in 3s
3 actionable tasks: 3 executed

- ./gradlew :module8:run -PmainClass='kafka.DescribeTopic'
> Task :module8:run 
```json
{ 
  "name": "trip-intent", 
  "configs": { 
    "compression.type": "producer", 
    "leader.replication.throttled.replicas": "", 
    "message.downconversion.enable": "true", 
    "min.insync.replicas": "1", 
    "segment.jitter.ms": "0", 
    "cleanup.policy": "delete", 
    "flush.ms": "9223372036854775807", 
    "follower.replication.throttled.replicas": "", 
    "segment.bytes": "1073741824", 
    "retention.ms": "604800000", 
    "flush.messages": "9223372036854775807", 
    "message.format.version": "2.8-IV1", 
    "max.compaction.lag.ms": "9223372036854775807", 
    "file.delete.delay.ms": "60000", 
    "max.message.bytes": "1048588", 
    "min.compaction.lag.ms": "0", 
    "message.timestamp.type": "CreateTime", 
    "preallocate": "false", 
    "min.cleanable.dirty.ratio": "0.5", 
    "index.interval.bytes": "4096", 
    "unclean.leader.election.enable": "false", 
    "retention.bytes": "-1", 
    "delete.retention.ms": "86400000", 
    "segment.ms": "604800000", 
    "message.timestamp.difference.max.ms": "9223372036854775807", 
    "segment.index.bytes": "10485760" 
  }, 
  "partitions": [ 
    { 
      "partition": 0, 
      "leader": 1002, 
      "replicas": [ 
        { 
          "broker": 1002, 
          "leader": true, 
          "in_sync": true 
        }, 
        { 
          "broker": 1001, 
          "leader": false, 
          "in_sync": true 
        }, 
        { 
          "broker": 1003, 
          "leader": false, 
          "in_sync": true 
        } 
      ] 
    }, 
    { 
      "partition": 1, 
      "leader": 1001, 
      "replicas": [ 
        { 
          "broker": 1001, 
          "leader": true, 
          "in_sync": true 
        }, 
        { 
          "broker": 1003, 
          "leader": false, 
          "in_sync": true 
        }, 
        { 
          "broker": 1002, 
          "leader": false, 
          "in_sync": true 
        } 
      ] 
    } 
  ] 
} 
```
BUILD SUCCESSFUL in 3s 
3 actionable tasks: 1 executed, 2 up-to-date 

- ./gradlew :module8:run -PmainClass='kafka.ProtobufBasicProducer'
> [main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka version: 5.5.0-ccs <br>
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka commitId: 785a156634af5f7e <br>
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka startTimeMs: 1627865488657 <br>
[kafka-producer-network-thread | producer-1] INFO org.apache.kafka.clients.Metadata - [Producer clientId=producer-1] Cluster ID: Hj4BHnYaS1OKS6N2r-3jTA <br><br>
BUILD SUCCESSFUL in 1s <br>
6 actionable tasks: 1 executed, 5 up-to-date <br>

- ./gradlew :module8:run -PmainClass='kafka.CreateSubscription'
```json
> Task :module8:run
{
  "instance_id": "consumer1",
  "base_uri": "http://rest-proxy:8082/consumers/booking_service/instances/consumer1"
}
204
```

- ./gradlew :module8:run -PmainClass='kafka.Produce'
```json
> Task :module8:run
{
  "offsets": [
    {
      "partition": 0,
      "offset": 1
    }
  ]
}
```
- ./gradlew :module8:run -PmainClass='kafka.Consume'

```json
> Task :module8:run
[
  {
    "topic": "trip-intent",
    "key": 213124,
    "value": {
      "userId": 213124,
      "latLonFrom": "48.2026,16.3688",
      "latLonTo": "48.1869,16.3133"
    },
    "partition": 0,
    "offset": 0
  },
  {
    "topic": "trip-intent",
    "key": 213124,
    "value": {
      "userId": 213124,
      "latLonFrom": "48.2026,16.3688",
      "latLonTo": "48.1869,16.3133"
    },
    "partition": 0,
    "offset": 1
  }
]
```
## To check Kafka logs:
docker-compose logs kafka1 | (**Select-String** on Windows or **grep** on Unix) "insync"

## To Access Confluent Control Center
http://localhost:9021
