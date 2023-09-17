package com.leeeryu.primitive;

public class DoubleClazz {
	public static void main(String[] args) {
		double d = 1.0;
		System.out.println(d);

		double d2 = 1.0d;

		System.out.println(d2);

		final Double v = new Double("0.230232");
		System.out.println(v.longValue());
		System.out.println(v.intValue());
		System.out.println(v.byteValue());

		String formattedNumber = String.format("%.2f", v);

		System.out.println(formattedNumber);
	}
}
