package in.co.bytehub.sample_service;

import in.co.bytehub.sample_service.integration.GreetServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    public HelloService(GreetServiceClient greetServiceClient) {
        this.greetServiceClient = greetServiceClient;
    }

    private final GreetServiceClient greetServiceClient;

    public String greet() {
        logger.info("Calling greet service client method to greet");
        return greetServiceClient.callGreet();
    }

    public String throwError() {
        logger.info("Calling greet service client method to raise error");
        return greetServiceClient.throwError();
    }


}
