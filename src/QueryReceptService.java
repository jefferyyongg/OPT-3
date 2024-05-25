import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class QueryReceptService extends ReceptApiService {

    @Override
    HttpResponse<String> handleHttpRequest(String query) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.spoonacular.com/recipes/complexSearch?apiKey=511f0eda5ee6487ea63b21e8660d8a88&query=" + query))
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }

    @Override
    Recept processHttpResponse(HttpResponse<String> response) {
        Scanner scanner = new Scanner(System.in);
        Recept recept = null;
        if (response.statusCode() == 200) {
            Gson gson = new Gson();
            ReceptQuery receptQuery = gson.fromJson(response.body(), ReceptQuery.class);
            System.out.println(receptQuery.getResults().size());
            for (int i = 0; i < receptQuery.getResults().size(); i++) {
                System.out.printf(i + ". Title: %s\n", receptQuery.getResults().get(i).getTitle());
                System.out.println();
            }
            System.out.println("Selecteer Recept: \n");
            String input = scanner.nextLine();
            return receptQuery.getResults().get(Integer.parseInt(input));
        } else {
            System.out.println(response.statusCode());
        }
        return recept;
    }
}
