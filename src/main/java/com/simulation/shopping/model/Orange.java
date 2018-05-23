package com.simulation.shopping.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.simulation.shopping.Market.Visitable;
import com.simulation.shopping.Market.Visitor;

public class Orange implements Visitable {

	private double pricePerKg;
	private double weight;
	private String name;

	public Orange(double priceKg, double weight, String name) {
		this.pricePerKg = priceKg;
		this.weight = weight;
		this.name = name;
	}

	public double getPricePerKg() {
		return pricePerKg;
	}

	public double getWeight() {
		return weight;
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
		BigDecimal pricePerKg = new BigDecimal(String.valueOf(this.pricePerKg));
		BigDecimal weight = new BigDecimal(String.valueOf(this.weight));
		BigDecimal priceTotal = pricePerKg.multiply(weight);
		priceTotal.setScale(2, RoundingMode.HALF_UP);
		return priceTotal.doubleValue();
	}

}
