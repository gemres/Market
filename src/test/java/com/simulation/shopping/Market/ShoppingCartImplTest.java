package com.simulation.shopping.Market;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.simulation.shopping.model.Bean;
import com.simulation.shopping.model.Coke;
import com.simulation.shopping.model.Orange;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartImplTest {

	private ShoppingCartImpl shoppingCartImpl;

	private static final double PRECISION = 0.00001;

	@Before
	public void setup() {
		shoppingCartImpl = new ShoppingCartImpl();

	}

	@Test
	public void TestCalculationDiscountAmountForCoke() {
		Coke coke = new Coke(0.70, 5, "Coke");
		double amount = shoppingCartImpl.visit(coke);
		assertEquals(amount, 0.8, PRECISION);

	}

	@Test
	public void TestCalculationDiscountAmountForCokeWithZeroDiscount() {
		Coke coke = new Coke(0.70, 1, "Coke");
		double amount = shoppingCartImpl.visit(coke);
		assertEquals(amount, 0, PRECISION);

	}

	@Test
	public void TestCalculationDiscountAmountForOrange() {
		Orange orange = new Orange(1.99, 0.250, "Orange");
		double amount = shoppingCartImpl.visit(orange);
		assertEquals(amount, 0, PRECISION);

	}

	@Test
	public void TestCalculationDiscountAmountForBean() {
		Bean bean = new Bean(0.50, 7, "Bean");
		double amount = shoppingCartImpl.visit(bean);
		assertEquals(amount, 1, PRECISION);

	}

	@Test
	public void TestCalculationDiscountAmountForBeanWithZeroDiscount() {
		Bean bean = new Bean(0.50, 2, "Bean");
		double amount = shoppingCartImpl.visit(bean);
		assertEquals(amount, 0, PRECISION);

	}

	@Test
	public void TestCalculationDiscountAmountForBeanWithDiscount() {
		Bean bean = new Bean(0.50, 3, "Bean");
		double amount = shoppingCartImpl.visit(bean);
		assertEquals(amount, 0.50, PRECISION);

	}

}
