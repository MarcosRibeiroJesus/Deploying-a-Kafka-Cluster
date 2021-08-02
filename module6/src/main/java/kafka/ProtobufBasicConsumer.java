package kafka;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.IntegerDeserializer;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class ProtobufBasicConsumer {
    public static void main(String[] args) throws Exception {

        var props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("key.deserializer", IntegerDeserializer.class.getName());
        props.setProperty("value.deserializer", ByteArrayDeserializer.class.getName());
        props.setProperty("group.id", "booking-service");

        KafkaConsumer<Integer, byte[]> consumer = new KafkaConsumer<>(props);

        consumer.subscribe(List.of("trip-intent"));

        while (true) {
            ConsumerRecords<Integer, byte[]> records = consumer.poll(Duration.ofMillis(100));
            for (var record : records) {
                // TODO: Get the message and print the pickup and drop off points
                byte[] bytes = record.value();
                var tripIntent = RideHailingProtos.TripIntent.parseFrom(bytes);
                System.out.printf(
                        "Trip from '%s' to '%s' requested.",
                        tripIntent.getLatLonFrom(), tripIntent.getLatLonTo());
            }
        }
    }
}
