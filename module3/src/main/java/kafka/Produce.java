package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Produce {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        ProducerRecord<String, String> r1 = new ProducerRecord<>("quote-feedback", "Booking 8321 accepted.");
        ProducerRecord<String, String> r2 = new ProducerRecord<>("quote-feedback", "Booking 8423 accepted.");
        ProducerRecord<String, String> r3 = new ProducerRecord<>("quote-feedback", "Booking 8424 accepted.");

        producer.send(r1);
        producer.send(r2);
        producer.send(r3);

        producer.flush();
        producer.close();
    }
}
