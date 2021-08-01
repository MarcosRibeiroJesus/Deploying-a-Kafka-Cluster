package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

public class ProduceMany {

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("key.serializer", IntegerSerializer.class.getName());
        props.setProperty("value.serializer", StringSerializer.class.getName());
        // TODO: 1 - Force no batching
        // props.setProperty("batch.size", "0");
        // TODO: 2 - Enable batching and tune it to produce ~ 10 messages/batch
        // props.setProperty("linger.ms", "100");
        // TODO: 3 - Change settings to produce ~ 100 messages/batch
        props.setProperty("linger.ms", "1000");
        // TODO: 4 - Enable compression
        props.setProperty("compression.type", "gzip");


        KafkaProducer<Integer, String> producer = new KafkaProducer<>(props);

        // Produce 5000 messages with random keys.
        for (int i = 0; i < 5000; i++) {
            var key = ThreadLocalRandom.current().nextInt(1, 1500);
            ProducerRecord<Integer, String> r1 =
                    new ProducerRecord<>("quote-feedback", key, "Booking accepted.");
            producer.send(r1);
            Thread.sleep(10);
        }

        producer.flush();
        producer.close();
    }

}
