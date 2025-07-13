package in.co.bytehub.sample_service.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class GreetServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(GreetServiceClient.class);
    private static final String GREET_SERVICE_URL = "http://greet-service:8080%s";

    private final HttpClient httpClient;

    public GreetServiceClient() {
        this.httpClient = HttpClient.newHttpClient();

    }

    public String callGreet() {
        return callServiceAndHandleResponse(HttpRequest.newBuilder()
                .uri(URI.create(GREET_SERVICE_URL.formatted("/greet")))
                .build());
    }

    public String throwError() {
        return callServiceAndHandleResponse(HttpRequest.newBuilder()
                .uri(URI.create(GREET_SERVICE_URL.formatted("/throw-error")))
                .build());
    }

    private String callServiceAndHandleResponse(HttpRequest httpRequest) {
        try {
            logger.info("Calling greet service with request: {}", httpRequest.uri());
            var response = this.httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (response == null) {
                logger.error("Response from greet service is null");
                throw new RuntimeException("Response is null");
            }
            if (response.statusCode() / 100 != 2) {
                logger.error("Response from greet service is not successful: {}", response.statusCode());

                throw new RuntimeException("Response is not successful: %s".formatted(response.statusCode()));
            }
            return response.body();
        } catch (Exception ex) {
            logger.error("Failed to call greet service", ex);
            throw new RuntimeException("Failed to call greet service", ex);
        }

    }
}
