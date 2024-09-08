import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.time.Duration;

public class HttpClient<T> {
    private final java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
    private final HttpResponse.BodyHandler<T> responseHandler;

    public HttpClient(HttpResponse.BodyHandler<T> responseHandler) {
        this.responseHandler = responseHandler;
    }

    public T get(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(url))
                .build();

        HttpResponse<T> response = client.send(request, responseHandler);
        return response.body();
    }
}
