package in.co.bytehub.sample_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello() {
        logger.info("Ask to generate greet message at {} ", LocalDateTime.now());
        return helloService.greet();
    }

    @GetMapping("/throw-error")
    public String throwError() {
        logger.info("Ask to throw error at {} ", LocalDateTime.now());
        try {
            return helloService.throwError();
        } catch (Exception e) {
            logger.error("Some error occurred: ", e);
            throw new RuntimeException(e);
        }
    }
}
