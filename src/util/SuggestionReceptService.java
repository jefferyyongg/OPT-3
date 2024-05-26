package util;

import model.ReceptQueryResult;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

public class SuggestionReceptService extends ReceptApiService{

    @Override
    HttpResponse<String> handleHttpRequest(String query) throws URISyntaxException, IOException, InterruptedException {
        return null;
    }

    @Override
    ReceptQueryResult processHttpResponse(HttpResponse<String> response) {
        return null;
    }

    @Override
    void responseToJson(String input) throws URISyntaxException, IOException, InterruptedException {

    }
}
