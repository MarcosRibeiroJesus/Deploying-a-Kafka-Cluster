package kafka;

import com.google.protobuf.DynamicMessage;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class ProtobufDynamicConsumer {
    public static void main(String[] args) throws Exception {


        var props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("group.id", "booking-service");
        props.setProperty("schema.registry.url", "http://localhost:8081");
        props.setProperty("key.deserializer", IntegerDeserializer.class.getName());
        props.setProperty("value.deserializer", KafkaProtobufDeserializer.class.getName());

        KafkaConsumer<Integer, DynamicMessage> consumer = new KafkaConsumer<>(props);

        consumer.subscribe(List.of("trip-intent"));

        while (true) {
            ConsumerRecords<Integer, DynamicMessage> records = consumer.poll(Duration.ofMillis(100));
            for (var record : records) {
                var val = record.value();
                // TODO: Check if the message contains lat_lon_from field and print its value
                val.getAllFields().forEach((fieldDescriptor, fieldValue) -> {
                    if (fieldDescriptor.getName().equals("lat_lon_from")) {
                        System.out.printf("Pickup location: %s%n", fieldValue);
                    }
                }
        );
            }
        }
    }
}
