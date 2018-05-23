package com.simulation.shopping.Market;

import com.simulation.shopping.model.Bean;
import com.simulation.shopping.model.Coke;
import com.simulation.shopping.model.Orange;

public class ShoppingCartImpl implements Visitor {

	public double visit(Coke coke) {
		int numOfDoubleCokes = 0;
		if (coke.getQuantity() < 2) {
			return 0;
		} else {

			numOfDoubleCokes = coke.getQuantity() / 2;
			return numOfDoubleCokes * 0.40;
		}
	}

	public double visit(Bean bean) {
		int numOfTripleBeans = 0;
		if (bean.getQuantity() < 3) {
			return 0;
		} else {

			numOfTripleBeans = bean.getQuantity() / 3;
			return numOfTripleBeans * 0.50;
		}

	}

	public double visit(Orange orange) {
		return 0;
	}

}
