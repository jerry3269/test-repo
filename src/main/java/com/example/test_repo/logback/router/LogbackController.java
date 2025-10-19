package com.example.test_repo.logback.router;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
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

    /**
     * MDC는 logback xml에서 사용할 수 있는 키-값 쌍을 설정하는 데 사용됩니다.
     * logback 설정 파일에서 %X{key}를 사용하여 MDC에 저장된 값을 로그 메시지에 포함시킬 수 있습니다.
     * 주로 멀티쓰레드 환경에서 쓰레드별로 고유한 정보(식별자 등)를 로그에 남기기 위해 사용됩니다.
     * MDC의 자료구조는 Map<String, String> 형태로 되어 있습니다.
     * MDC는 쓰레드별로 독립적으로 관리되어야 하기 때문에, 함수 종료 시 MDC.clear()를 호출하여 해당 쓰레드의 MDC를 정리해야합니다.
     */
    @GetMapping("/mdc")
    public String mdc() {
        MDC.put("mdc-key", "mdc-value");
        log.trace("This is a TRACE log message.");
        log.debug("This is a DEBUG log message.");
        log.info("This is an INFO log message.");
        log.warn("This is a WARN log message.");
        log.error("This is an ERROR log message.");
        MDC.clear();
        return "mdc test complete";
    }
}
