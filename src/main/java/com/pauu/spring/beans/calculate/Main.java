package com.pauu.spring.beans.calculate;

public class Main {
	public static void main(String[] args) {
		ArimeticCalculator arimeticCalculator = null;
		arimeticCalculator = new ArimeticCalculatorImplLogging();
		int result = arimeticCalculator.add(3, 5);
		System.out.println("result--->"+result);
		result = arimeticCalculator.div(10, 2);
		System.out.println("result--->"+result);
	}
}
