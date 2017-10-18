package com.vivekaditya;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestControllerAspect {
	// private static final Class<RestControllerAspect> restControllerAspectClass = RestControllerAspect.class;
	// private static final Logger log = LoggerFactory.getLogger(restControllerAspectClass);

	@Before("execution(public * com.vivekaditya.api.rest.*Controller.*(..))")
	public void logBeforeRestCall(JoinPoint pjp) throws Throwable {
		System.out.println(pjp.toString());
	}
}
