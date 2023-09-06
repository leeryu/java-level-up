package com.leeeryu.data;

import java.util.*;
import java.util.stream.Collectors;

public class PivotClazz {
	public static void main(String[] args) {
		List<Sale> sales = new ArrayList<>();
		sales.add(new Sale("2023-08-01", "ProductA", 100));
		sales.add(new Sale("2023-08-01", "ProductB", 150));
		sales.add(new Sale("2023-08-02", "ProductA", 120));
		sales.add(new Sale("2023-08-02", "ProductB", 180));

		Map<String, Map<String, Double>> pivotData = new HashMap<>();

		for (Sale sale : sales) {
			if (!pivotData.containsKey(sale.getDate()))
				pivotData.put(sale.getDate(), new HashMap<>());

			pivotData.get(sale.getDate()).put(sale.getProduct(), sale.getAmount());
		}

//		System.out.print("Date       | ");
//		for (String product : pivotData.get(sales.get(0).getDate()).keySet()) {
//			System.out.print(product + " | ");
//		}
//		System.out.println();
//
//		for (Map.Entry<String, Map<String, Double>> entry : pivotData.entrySet()) {
//			System.out.print(entry.getKey() + " | ");
//			for (double amount : entry.getValue().values()) {
//				System.out.print(amount + " | ");
//			}
//			System.out.println();
//		}
//

		sales.stream().collect(Collectors.groupingBy(Sale::getDate,
				Collectors.toMap(Sale::getProduct, Sale::getAmount)))
				.forEach((date, productMap) -> {
					System.out.print(date + "   |");
					productMap.forEach((product, amount) -> {
						System.out.print(amount + "   |");
					});
					System.out.println();
				});
	}
}

class Sale {
	private String date;
	private String product;
	private double amount;

	public Sale(String date, String product, double amount) {
		this.date = date;
		this.product = product;
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public String getProduct() {
		return product;
	}

	public double getAmount() {
		return amount;
	}
}
