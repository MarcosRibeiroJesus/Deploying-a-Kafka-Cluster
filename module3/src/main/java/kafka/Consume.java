package kafka;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class Consume {

    public static void main(String[] args) {

        String consumerGroup = args[0];
        System.out.printf("Consumer group: %s%n", consumerGroup);

        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("group.id", consumerGroup);
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        // props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", StringDeserializer.class.getName());

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(List.of("quote-feedback"));

        while (true) {
            // TODO: Get messages from Kafka, and for each of them, print its value, offset and partition.
            ConsumerRecords<String,String> records = consumer.poll(Duration.ofMillis(1000));
            for (var record : records) {
                System.out.printf(
                    "Message '%s' at offset %d of partition %s%n", 
                    record.value(), 
                    record.offset(), 
                    record.partition()
                    );
            }
        }
    }
}
