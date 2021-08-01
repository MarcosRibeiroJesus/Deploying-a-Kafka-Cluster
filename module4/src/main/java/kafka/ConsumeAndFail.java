package kafka;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class ConsumeAndFail {

    public static void main(String[] args) throws Exception {

        String consumerGroup = args[0];
        System.out.printf("Consumer group: %s%n", consumerGroup);

        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("group.id", consumerGroup);
        props.setProperty("key.deserializer", IntegerDeserializer.class.getName());
        props.setProperty("value.deserializer", StringDeserializer.class.getName());

        props.setProperty("max.poll.interval.ms", "10000");

        KafkaConsumer<Integer, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(List.of("quote-feedback"));

        /*
         TODO: Create artificial situation where after processing 5 messages the consumer cannot make
          progress to the next 'poll' call
         */
        var consumedMessagesCount = 0;

        while (true) {
            ConsumerRecords<Integer, String> records = consumer.poll(Duration.ofMillis(100));
            for (var record : records) {
                System.out.printf("Message '%s' at offset %d of partition %s%n", record.value(),
                        record.offset(), record.partition());
                        consumedMessagesCount++;
                        if(consumedMessagesCount > 4) {
                            System.out.println("Oops there is a problem...");
                            Thread.sleep(60000);
                        };
            }
        }
    }
}
