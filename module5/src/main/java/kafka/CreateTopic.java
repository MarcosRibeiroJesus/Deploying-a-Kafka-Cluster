package kafka;

import org.apache.kafka.clients.admin.Admin;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.List;
import java.util.Map;

public class CreateTopic {
    public static void main(String[] args) throws Exception {

        Admin admin = Admin.create(
                Map.of("bootstrap.servers", "localhost:9091,localhost:9092,localhost:9093")
        );

        // TODO - Set minimum number of in-sync replicas to 2
        Map<String, String> topicConfig = Map.of("min.insync.replicas", "2");

        NewTopic newTopic = new NewTopic("quote-feedback", 2, (short) 3)
        .configs(topicConfig);
        admin.createTopics(List.of(newTopic))
                .all()
                .get();
        printAllTopics(admin);
        admin.close();
    }

    static void printAllTopics(Admin client) throws Exception {
        var topics = client.listTopics().names().get();
        System.out.println("Topics in the cluster:");
        topics.forEach(System.out::println);
        System.out.println();
    }
}
