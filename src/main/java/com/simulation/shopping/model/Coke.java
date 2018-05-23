package com.simulation.shopping.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.simulation.shopping.Market.Visitable;
import com.simulation.shopping.Market.Visitor;


public class Coke implements Visitable {
	private double price;
	private int quantity;
	private String name;
	
	
	public Coke(double price, int quantity, String name){
		this.price = price;
		this.quantity = quantity;
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}
	
	public double getTotalPrice() {
		BigDecimal price = new BigDecimal(String.valueOf(this.price));
		BigDecimal quantity = new BigDecimal(String.valueOf(this.quantity));
		BigDecimal priceTotal = price.multiply(quantity);
		priceTotal.setScale(2, RoundingMode.DOWN);
		return priceTotal.doubleValue();
	}

}
