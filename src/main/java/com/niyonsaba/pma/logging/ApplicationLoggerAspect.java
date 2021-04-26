package com.niyonsaba.pma.logging;


import org.aspectj.lang.annotation.After;
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
	
	@After("definePackagePointcuts()")
	public void log() {
		log.debug("_________________________________");
	}
	
	@Before("definePackagePointcuts()")
	public void logBefore() {
		log.debug("_________________________________");
	}
}
