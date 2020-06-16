package com.revature.blackjack.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class CardControllerAspect {

	@Autowired
	Logger log;
	
	//hook - empty method with an annotation
	@Pointcut("execution(* com.revature.blackjack.service.CardServiceImpl.*(..)")
	public void cardServiceMethods() {
		
	}

	@Before("cardServiceMethods()")
	public void beforeCardControllerMethods(JoinPoint jp) {
		System.out.println("Card Service method called");
		log.trace("Card Service method called");
	}
	
	@AfterReturning("cardServiceMethods()")
	public void afterCardServiceMethods(JoinPoint jp) {
		
	}

}
