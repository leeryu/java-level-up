package com.leeeryu.lamda;

import java.util.function.BinaryOperator;

/**
 * 같은 타입의 피연산자 두 개에 대한 연산을 나타내며 피연산자와 같은 타입의 결과를 생성합니다.
 * 피연산자와 결과가 모두 같은 타입인 경우에 대한 BiFunction의 특수화입니다.
 * 함수 메서드가 적용(Object, Object)인 함수형 인터페이스입니다.
 */
public class BinaryOperatorExample {
	public static void main(String[] args) {
		BinaryOperator<Double> operator = (a, b) -> a + b;
		System.out.println(operator.apply((double) 1, (double) 2));
	}
}
