package com.pauu.spring.beans.calculate;

public class ArithmeticCalculatorImplLogging implements ArithmeticCalculator {

	public int add(int i, int j) {
		System.out.println("The method add begin with["+i+","+j+"]");
		int result = i+j;
		System.out.println("The method add end with "+result);
		return result;
	}

	public int sub(int i, int j) {
		System.out.println("The method sub begin with["+i+","+j+"]");
		int result = i-j;
		System.out.println("The method sub end with "+result);
		return result;
	}

	public int mul(int i, int j) {
		System.out.println("The method mul begin with["+i+","+j+"]");
		int result = i*j;
		System.out.println("The method mul end with "+result);
		return result;
	}

	public int div(int i, int j) {
		System.out.println("The method div begin with["+i+","+j+"]");
		int result = i/j;
		System.out.println("The method div end with "+result);
		return result;
	}

}
