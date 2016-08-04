package com.pauu.spring.beans.calculate;

import com.pauu.spring.beans.aop.impl.ArithmeticCalculator;
import com.pauu.spring.beans.aop.impl.ArithmeticCalculatorImpl;

public class Main {
	public static void main(String[] args) {
		/*ArithmeticCalculator arimeticCalculator = null;
		arimeticCalculator = new ArithmeticCalculatorImplLogging();*/
		ArithmeticCalculator target = new ArithmeticCalculatorImpl();
		ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
		int result = proxy.add(3, 5);
		System.out.println("result--->"+result);
		result = proxy.div(10, 2);
		System.out.println("result--->"+result);
	}
}
