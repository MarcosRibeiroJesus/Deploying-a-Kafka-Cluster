package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Produce {

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9091,localhost:9092,localhost:9093");
        props.setProperty("key.serializer", IntegerSerializer.class.getName());
        props.setProperty("value.serializer", StringSerializer.class.getName());

        props.setProperty("acks", "all");

        KafkaProducer<Integer, String> producer = new KafkaProducer<>(props);

        ProducerRecord<Integer, String> r1 =
                new ProducerRecord<>("quote-feedback", 12334, "Booking 8321 accepted.");
        var r2 = new ProducerRecord<>("quote-feedback", 12335, "Booking 8423 accepted.");
        var r3 = new ProducerRecord<>("quote-feedback", 12334, "Booking 8424 accepted.");

        RecordMetadata rm = producer.send(r1).get();
        System.out.println();
        System.out.printf("Value with key %d assigned to partition: %d%n", r1.key(), rm.partition());
        rm = producer.send(r2).get();
        System.out.printf("Value with key %d assigned to partition: %d%n", r2.key(), rm.partition());
        rm = producer.send(r3).get();
        System.out.printf("Value with key %d assigned to partition: %d%n", r3.key(), rm.partition());
        System.out.println();

        producer.flush();
        producer.close();
    }

}
