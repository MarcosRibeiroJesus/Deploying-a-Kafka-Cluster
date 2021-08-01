package kafka;

import org.apache.kafka.clients.admin.Admin;
import org.apache.kafka.clients.admin.ListTopicsOptions;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.List;
import java.util.Map;

public class ListTopics {
    public static void main(String[] args) throws Exception {

        Admin admin = Admin.create(
                Map.of("bootstrap.servers", "localhost:9092")
        );

        printAllTopics(admin);
        admin.close();
    }

    static void printAllTopics(Admin client) throws Exception {
        var topics = client.listTopics(new ListTopicsOptions().listInternal(true)).names().get();
        System.out.println("Topics in the cluster:");
        topics.forEach(System.out::println);
        System.out.println();
    }
}
