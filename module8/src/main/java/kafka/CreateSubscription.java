package kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class CreateSubscription {

    public static void main(String[] args) throws Exception {

        HttpClient client = HttpClient.newHttpClient();
        var json = Path.of(
                Produce.class.getResource("/consumer.json").toURI()
        );

        // Create a consumer
        HttpRequest req1 = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8082/consumers/booking_service"))
                .header("Content-Type", "application/vnd.kafka.v2+json")
                .POST(HttpRequest.BodyPublishers.ofFile(json))
                .build();
        HttpResponse<String> resp1 = client.send(req1, HttpResponse.BodyHandlers.ofString());
        printResponse(resp1);

        // Create a subscription
        HttpRequest req2 = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8082/consumers/booking_service/instances/consumer1/subscription"))
                .header("Content-Type", "application/vnd.kafka.v2+json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"topics\": [\"trip-intent\"]}"))
                .build();
        HttpResponse<String> resp2 = client.send(req2, HttpResponse.BodyHandlers.ofString());
        System.out.println(resp2.statusCode());
    }

    public static void printResponse(HttpResponse<String> resp) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement el = JsonParser.parseString(resp.body());
        String jsonString = gson.toJson(el);
        System.out.println(jsonString);
    }
}
