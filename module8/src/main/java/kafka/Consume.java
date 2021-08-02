package kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consume {

    public static void main(String[] args) throws Exception {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8082/consumers/booking_service/instances/consumer1/records"))
                .header("Content-Type", "application/vnd.kafka.json.v2+json")
                .header("Accept", "application/vnd.kafka.json.v2+json")
                .GET()
                .build();

        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        printResponse(resp);

    }

    public static void printResponse(HttpResponse<String> resp) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement el = JsonParser.parseString(resp.body());
        String jsonString = gson.toJson(el);
        System.out.println(jsonString);
    }
}
