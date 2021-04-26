package com.niyonsaba.pma.logging;


import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;


@Aspect
@Component
public class ApplicationLoggerAspect {
	private final Logger log = (Logger) LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(com.niyonsaba.pma.controllers..*)"
			+ "*|| within(com.niyonsaba.pma.dao..*")
	public void definePackagePointcuts() {
		//Empty method just to name the location specified in the pointcut
	}
	
//	@Before("definePackagePointcuts()")
//	public void logBefore(JoinPoint jp) {
//		log.debug(" \n \n \n ");
//		log.debug("********** Before Method execution ***** \n {}.{} () with arguments[s] = {}",
//				jp.getSignature().getDeclaringTypeName(),
//				jp.getSignature().getName(),
//				Arrays.toString(jp.getArgs()));
//		log.debug("_________________________________ \n \n \n ");
//	}
//	
//	@After("definePackagePointcuts()")
//	public void logAfter(JoinPoint jp) {
//		log.debug(" \n \n \n ");
//		log.debug("********** After Method execution ***** \n {}.{} () with arguments[s] = {}",
//				jp.getSignature().getDeclaringTypeName(),
//				jp.getSignature().getName(),
//				Arrays.toString(jp.getArgs()));
//		log.debug("_________________________________ \n \n \n ");
//	}
	
	@Around("definePackagePointcuts()")
	public Object logAround(ProceedingJoinPoint jp) {
		log.debug(" \n \n \n ");
		log.debug("********** Before Method execution ***** \n {}.{} () with arguments[s] = {}",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(),
				Arrays.toString(jp.getArgs()));
		log.debug("_________________________________ \n \n \n ");
		
		Object o= null;
		try {
			o = jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.debug(" \n \n \n ");
		log.debug("********** After Method execution ***** \n {}.{} () with arguments[s] = {}",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(),
				Arrays.toString(jp.getArgs()));
		log.debug("_________________________________ \n \n \n ");
		
		return o;
		
	}
	
	
}
