package com.simulation.shopping.Market;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.simulation.shopping.model.Bean;
import com.simulation.shopping.model.Coke;
import com.simulation.shopping.model.Orange;

public class App {

	public static void main(String[] args) {

		Coke coke = new Coke(0.70, 10, "Coke");
		Bean bean = new Bean(0.50, 6, "Bean");
		Orange orange = new Orange(1.99, 1.300, "Orange");
		Visitable[] items = new Visitable[] { coke, bean, orange };
		Visitor visitor = new ShoppingCartImpl();

		double total = calculateSubTotal(items);
		System.out.println("Sub Total = " + String.format("%.2f", total));
		double discountBean = bean.accept(visitor);
		System.out.println("Beans 3 for 2 = " + String.format("%.2f", discountBean));
		double discountCoke = coke.accept(visitor);
		System.out.println("Coke 2 for £1 = " + String.format("%.2f", discountCoke));
		double totalDiscountAmount = calculateTotalSavings(items, visitor);
		System.out.println("Total Savings = " + String.format("%.2f", totalDiscountAmount));
		double totalAfterDiscount = calculateTotalToPay(items, visitor);
		System.out.println("Total To Pay = " + String.format("%.2f", totalAfterDiscount));
	}

	public static double calculateTotalSavings(Visitable[] items, Visitor visitor) {

		BigDecimal sum = new BigDecimal("0");
		for (Visitable item : items) {
			sum = sum.add(new BigDecimal(String.valueOf(item.accept(visitor))));
		}
		sum = sum.setScale(2, RoundingMode.DOWN);
		return sum.doubleValue();

	}

	public static double calculateTotalToPay(Visitable[] items, Visitor visitor) {
		BigDecimal subTotal = new BigDecimal(String.valueOf(calculateSubTotal(items)));
		BigDecimal totalDiscount = new BigDecimal(String.valueOf(calculateTotalSavings(items, visitor)));
		return subTotal.subtract(totalDiscount).setScale(2, RoundingMode.DOWN).doubleValue();

	}

	public static double calculateSubTotal(Visitable[] items) {
		BigDecimal sum = new BigDecimal("0");

		for (Visitable item : items) {
			sum = sum.add(new BigDecimal(String.valueOf(item.getTotalPrice())));
		}
		sum = sum.setScale(2, RoundingMode.DOWN);
		return sum.doubleValue();
	}

}