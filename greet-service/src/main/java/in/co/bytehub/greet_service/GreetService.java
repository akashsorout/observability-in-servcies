package in.co.bytehub.greet_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class GreetService {

    private static final Logger logger = LoggerFactory.getLogger(GreetService.class);

    public String greet() {
        logger.info("Generating Greet Message at {} ", LocalDateTime.now());
        return "Hello India: " + LocalDateTime.now();
    }

    public String throwError() {
        logger.info("Generating Error Message");
        String str = null;
        Objects.requireNonNull(str);
        return "Hello error: " + LocalDateTime.now();
    }

}
