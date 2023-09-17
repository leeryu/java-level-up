package com.leeeryu.lamda;

import java.util.function.Supplier;

/**
 * 결과 공급자를 나타냅니다.
 * 공급자를 호출할 때마다 새 결과나 고유한 결과를 반환할 필요는 없습니다.
 * 함수형 메서드가 get()인 함수형 인터페이스입니다.
 */
public class SupplierExample {
	public static void main(String[] args) {
		// Supplier는 인자를 받지 않고 리턴값만 있는 함수형 인터페이스
		// get() 메서드를 구현해야 함
		// Supplier<String> supplier = () -> "Hello World";
		// Supplier<String> supplier
		// 		= () -> {

		 Supplier<String> supplier = () -> "Hello World";

		System.out.println(supplier.get());
	}
}
