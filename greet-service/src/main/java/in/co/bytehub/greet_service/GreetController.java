package in.co.bytehub.greet_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController

public class GreetController {

    private static final Logger logger = LoggerFactory.getLogger(GreetController.class);

    public GreetController(GreetService greetService) {
        this.greetService = greetService;
    }

    private final GreetService greetService;

    @GetMapping("/greet")
    public String greet() {
        logger.info("Ask to generate greet message at {} ", LocalDateTime.now());
        return greetService.greet();
    }

    @GetMapping("/throw-error")
    public String throwError() {
        logger.info("Ask to throw error at {} ", LocalDateTime.now());
        return greetService.throwError();
    }
}
