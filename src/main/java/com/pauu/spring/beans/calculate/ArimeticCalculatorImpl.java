package com.pauu.spring.beans.calculate;

public class ArimeticCalculatorImpl implements ArimeticCalculator {

	public int add(int i, int j) {
		int result = i+j;
		return result;
	}

	public int sub(int i, int j) {
		int result = i-j;
		return result;
	}

	public int mul(int i, int j) {
		int result = i*j;
		return result;
	}

	public int div(int i, int j) {
		int result = i/j;
		return result;
	}

}
