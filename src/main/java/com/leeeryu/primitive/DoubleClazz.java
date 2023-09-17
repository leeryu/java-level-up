package com.leeeryu.primitive;


public class DoubleClazz {
	public static void main(String[] args) {
//		System.out.println(2000 * 1329.16);
		// cif(물품가격 + 국제 운송료 + 적하보험) * 환율
//		System.out.println((2000 + 100 + 20.00) * 1329.16);
//		System.out.println((2818334.00 * 9) / 100 );

		// 환전율
		//
//		System.out.println(899.13 / 1329.16 );
		// 일본(jpy) -> 미국(usd)
//		System.out.println(  ((899.13 / 1329.16) * 150));
		// 미국(usd) -> 영국(gbp)
//		System.out.println(  1658.26/ (1329.16 * 150));
//		System.out.println((3000 + 10 + 20.00) * 1329.16);
		// 한국(krw) -> 일본(jpy)
		System.out.println(30000 * (915.80) + " JPY");
		// 한국(krw) -> 러시아(rub)
//		System.out.println(30000 * (1 / 14.92) + " RUB");
		// 호주(aud) -> 미국(usd)
//		System.out.println(1329.16 / 875.01);
//		System.out.println(30000 * 1.52 + " AUD");
		// ksr/rub
		System.out.println((1 / 13.83) * 10000	);
	}
	// 환전율 계산

	public static double exchangeRate(double price, double shipping, double insurance, double exchangeRate) {
		return (price + shipping + insurance) * exchangeRate;
	}
	public static double cif(double price, double shipping, double insurance) {
		return price + shipping + insurance;
	}
}
