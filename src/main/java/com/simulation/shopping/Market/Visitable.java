package com.simulation.shopping.Market;

public interface Visitable {
	public double accept(Visitor visitor);
	public double getTotalPrice();
	
}
