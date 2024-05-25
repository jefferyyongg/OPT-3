import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

public class ProcessReceptService extends ReceptApiService{

    @Override
    HttpResponse<String> handleHttpRequest(String query) throws URISyntaxException, IOException, InterruptedException {
        return null;
    }

    @Override
    Recept processHttpResponse(HttpResponse<String> response) {
        return null;
    }
}
