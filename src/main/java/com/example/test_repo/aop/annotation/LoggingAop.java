package com.example.test_repo.aop.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAop {

    @Around("@annotation(Logging) || @within(Logging)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        log.info("▶️ [START] {}", methodName);
        long start = System.currentTimeMillis();

        try {
            Object result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            log.info("✅ [END] {} ({}ms)", methodName, end - start);
            return result;
        } catch (Throwable e) {
            log.error("❌ [EXCEPTION] {} - {}", methodName, e.getMessage());
            throw e;
        }
    }
}
