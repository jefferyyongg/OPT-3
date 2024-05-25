import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

public abstract class ReceptApiService {

    abstract HttpResponse<String>  handleHttpRequest(String query) throws URISyntaxException, IOException, InterruptedException;
    abstract Recept processHttpResponse(HttpResponse<String> response);
}
