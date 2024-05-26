package util;

import model.ReceptQueryResult;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

public abstract class ReceptApiService {

    abstract HttpResponse<String>  handleHttpRequest(String query) throws URISyntaxException, IOException, InterruptedException;
    abstract ReceptQueryResult processHttpResponse(HttpResponse<String> response);
    abstract void responseToJson(String input) throws URISyntaxException, IOException, InterruptedException;
}
