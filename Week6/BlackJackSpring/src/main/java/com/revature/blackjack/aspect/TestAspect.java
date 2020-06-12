package com.revature.blackjack.aspect;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.revature.blackjack.domain.Player;

@Aspect
@Component
public class TestAspect {
    
	@Before("execution(* com.revature.blackjack.service.PlayerService.getAllPlayers(..))") //point-cut expression
    public void logBeforeAllPlayers(JoinPoint joinPoint)
    {
        System.out.println("-------------------After Methods() : " + joinPoint.getSignature().getName());
    }
	
	
    @After("execution(* com.revature.blackjack.service.PlayerService.getAllPlayers(..))") //point-cut expression
    public void logAfterAllPlayers(JoinPoint joinPoint)
    {
        System.out.println("-------------------After Methods() : " +joinPoint.getSignature().getName());
    }
    
    @AfterReturning(pointcut = "execution(* com.revature.blackjack.service.PlayerService.getAllPlayers(..))",returning="retVal") //point-cut expression
    public void logAfterReturningAllPlayers(JoinPoint joinPoint,Object retVal)
    {
    	ArrayList<Player> list=(ArrayList<Player>) retVal;
        System.out.println("-------------------After Returning Methods() : " + list.get(0).toString());
    }
    
    @Around("execution(* com.revature.blackjack.service.PlayerService.getAllPlayers(..))") //point-cut expression
    public Object logAroundReturningAllPlayers(ProceedingJoinPoint joinPoint)
    {
        System.out.println("-------------------After Returning Methods() : ");
        List<Player> list=null;
        try {
        	list= (List<Player>) joinPoint.proceed();
        	list.removeAll(list);
        	Player p=new Player();
        	p.setId(15);
        	p.setName("You will never see the list");
        	p.setPlayerType("Redirected");
        	p.setTokens(15);
        	list.add(p);
		} catch (Throwable e) {
			e.printStackTrace();
		}
        return list;
    }
}