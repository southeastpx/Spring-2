package com.pauu.spring.beans.aop.impl;


import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//把这个类声明为一个切面:①需要把该类放入IOC容器中②声明为一个切面
@Component
@Aspect
public class LoggingAspect {
	//声明该方法是一个前置通知：在目标方法之前执行
	@Before("execution(public int com.pauu.spring.beans.aop.impl.ArithmeticCalculator.*(int, int))")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The Method "+methodName+" begin with"+args);
	}
	
	//后置通知：在目标方法执行后（无论是否发生异常）执行的通知
	//在后置通知中不能访问目标方法执行的结果
	@After("execution(* com.pauu.spring.beans.aop.impl.ArithmeticCalculator.*(int, int))")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The Method "+methodName+" end");
	}
}
