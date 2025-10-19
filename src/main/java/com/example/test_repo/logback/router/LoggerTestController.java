package com.example.test_repo.logback.router;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/logback/logger")
@RestController
public class LoggerTestController {

    /**
     * LoggerFactory를 사용하여 Logger 인스턴스를 생성
     * log라는 변수의 이름은 이미 @Slf4j 어노테이션에 의해 사용되고 있으므로
     * log2라는 이름으로 Logger 인스턴스를 생성
     * 이렇게 설정하면 log2는 log와 동일한 Logger 인스턴스를 참조하게 됨
     * 즉 @Slf4j 어노테이션과 이 코드 중 하나만 사용
     */
    private static final Logger log2 = LoggerFactory.getLogger(LoggerTestController.class);

    /**
     * LOGGER_TEST라는 이름의 logger를 가져와서 log3라는 이름으로 Logger 인스턴스를 생성
     * log3을 사용하면 logback 설정 파일에서 LOGGER_TEST 이름으로 정의된 설정을 사용할 수 있음
     */
    private static final Logger log3 = LoggerFactory.getLogger("LOGGER_TEST");

    @GetMapping
    public String loggerTest() {
        log.trace("This is a TRACE log message.");
        log.debug("This is a DEBUG log message.");
        log.info("This is an INFO log message.");
        log.warn("This is a WARN log message.");
        log.error("This is an ERROR log message.");
        return "log == log2: " + (log == log2);
    }
}
