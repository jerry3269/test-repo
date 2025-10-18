package com.example.test_repo.logback.router;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/logback")
@RestController
public class LogbackController {

    @GetMapping
    public void test() {
        log.trace("This is a TRACE log message.");
        log.debug("This is a DEBUG log message.");
        log.info("This is an INFO log message.");
        log.warn("This is a WARN log message.");
        log.error("This is an ERROR log message.");
    }
}
