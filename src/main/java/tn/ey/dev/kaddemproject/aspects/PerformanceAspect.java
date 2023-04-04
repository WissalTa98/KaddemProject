package tn.ey.dev.kaddemproject.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class PerformanceAspect {
    @Around("execution(* tn.ey.dev.kaddemproject.services.*.*(..))")
    public Object executionTime(ProceedingJoinPoint pjp) throws Throwable {
        long t1 = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long executionTime = System.currentTimeMillis() - t1;
        String methodeName = pjp.getSignature().getName();

        log.debug("The runtime of the method ( " + methodeName + " ) = " + executionTime + " milliseconds.");
        return obj;
    }
}
