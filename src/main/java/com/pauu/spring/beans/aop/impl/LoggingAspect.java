package com.pauu.spring.beans.aop.impl;


import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	//返回通知：在目标方法正常执行后执行的代码
	//返回通知可以访问到方法的返回值
	@AfterReturning(value="execution(* com.pauu.spring.beans.aop.impl.ArithmeticCalculator.*(int, int))",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The Method "+methodName+" end with "+result);
	}
	//异常通知:在目标方法出现异常时会执行的代码
	//可以访问到异常对象，并且可以指定在出现特定异常时再执行代码
	@AfterThrowing(value="execution(* com.pauu.spring.beans.aop.impl.ArithmeticCalculator.*(int, int))",throwing="ex")
	public void afterThrowing(JoinPoint joinPoint,Exception ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The Method "+methodName+" occurs Exception:"+ex);
	}
	//环绕通知需要接受ProceedingJoinPoint类型的参数
	//环绕通知类似于动态代理的全过程：ProceedingJoinPoint类型的参数可以决定是否执行目标方法
	//环绕通知必须有返回值，返回值即为目标方法的返回值
	@Around("execution(* com.pauu.spring.beans.aop.impl.ArithmeticCalculator.*(int, int))")
	public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
		Object result = null;
		String methodName = proceedingJoinPoint.getSignature().getName();
		try {
			//前置通知
			System.out.println("The Method "+methodName+" begin with "+proceedingJoinPoint.getArgs());
			//执行目标方法
			result = proceedingJoinPoint.proceed();
			//返回通知
			System.out.println("The Method "+methodName+" ends with "+result);
		} catch (Throwable e) {
			//异常通知
			System.out.println("The Method "+methodName+" occurs Exception "+e);
			throw new RuntimeException(e);
		}
		//后置通知
		System.out.println("The Method "+methodName+" ends");
		return result;
	}
}
