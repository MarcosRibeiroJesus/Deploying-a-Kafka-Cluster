package kafka;

import org.apache.kafka.clients.admin.Admin;

import java.util.Map;

public class ConsumerGroups {
    public static void main(String[] args) throws Exception {

        Admin admin = Admin.create(
                Map.of("bootstrap.servers", "localhost:9092")
        );

        System.out.printf("%nPrinting offsets for dispatch-service consumer group.%n");

        admin.listConsumerGroupOffsets("dispatch-service")
                .partitionsToOffsetAndMetadata()
                .get()
                .forEach((partition, offsetAndMetadata) -> {
                    System.out.printf("Partition %s with offset %d%n", partition, offsetAndMetadata.offset());
                });
        admin.close();
    }

}
