package com.simulation.shopping.Market;

import com.simulation.shopping.model.Bean;
import com.simulation.shopping.model.Coke;
import com.simulation.shopping.model.Orange;

public interface Visitor {
	public double visit(Orange orange);

	public double visit(Coke coke);

	public double visit(Bean bean);
}
