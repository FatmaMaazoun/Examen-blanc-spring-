package tn.esprit.maazounfatmaexamen.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class logingaspect {

    @After("execution (* tn.esprit.maazounfatmaexamen.services.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint){
        log.info("Méthode exécutée "+joinPoint.getSignature().getName());
    }
}
