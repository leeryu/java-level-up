package com.leeeryu.regex;

import java.util.regex.Pattern;

public class RegexExample {
	public static void main(String[] args) {
		// 정규식 으로 자르기
		String input = "0.7%/kg|+10%";

		System.out.println(Pattern.matches("10", input));
	}
}
