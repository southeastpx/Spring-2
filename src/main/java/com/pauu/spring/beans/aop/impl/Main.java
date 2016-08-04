package com.pauu.spring.beans.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//1.创建Spring IOC容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.从IOC容器中获取bean实例
		ArithmeticCalculator arithmeticCalculator = ctx.getBean(ArithmeticCalculator.class);
		//3.使用bean实例
		int result = arithmeticCalculator.add(3, 6);
		System.out.println("result:"+result);
		result = arithmeticCalculator.div(18, 9);
		System.out.println("result:"+result);
	}
}
