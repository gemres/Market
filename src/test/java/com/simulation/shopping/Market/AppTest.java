package com.simulation.shopping.Market;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.simulation.shopping.model.Bean;
import com.simulation.shopping.model.Coke;
import com.simulation.shopping.model.Orange;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {
	private App app;

	private static final double PRECISION = 0.00001;

	@Mock
	private ShoppingCartImpl shoppingCartImpl;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		app = new App();

	}

	@Test
	public void TestCalculateSubTotal() {

		Coke coke = new Coke(0.70, 10, "Coke");
		Bean bean = new Bean(0.50, 6, "Bean");
		Orange orange = new Orange(1.99, 1.0, "Orange");
		Visitable[] items = new Visitable[] { coke, bean, orange };

		double total = app.calculateSubTotal(items);
		assertEquals(total, 11.99, PRECISION);

	}

	@Test
	public void TestCalculateTotalSavings() {

		Coke coke = new Coke(0.70, 10, "Coke");
		Bean bean = new Bean(0.50, 6, "Bean");
		Orange orange = new Orange(1.99, 1.0, "Orange");
		Visitable[] items = new Visitable[] { coke, bean, orange };

		when(shoppingCartImpl.visit(coke)).thenReturn(1.6);
		when(shoppingCartImpl.visit(bean)).thenReturn(1.6);
		when(shoppingCartImpl.visit(orange)).thenReturn(1.6);

		double total = app.calculateTotalSavings(items, shoppingCartImpl);
		assertEquals(total, 4.8, PRECISION);

	}

	@Test
	public void TestCalculateTotalToPay() {

		Coke coke = new Coke(0.70, 10, "Coke");
		Bean bean = new Bean(0.50, 6, "Bean");
		Orange orange = new Orange(1.99, 1.0, "Orange");
		Visitable[] items = new Visitable[] { coke, bean, orange };

		when(shoppingCartImpl.visit(coke)).thenReturn(1.0);
		when(shoppingCartImpl.visit(bean)).thenReturn(1.99);
		when(shoppingCartImpl.visit(orange)).thenReturn(1.0);

		double total = app.calculateTotalToPay(items, shoppingCartImpl);
		assertEquals(total, 8.0, PRECISION);

	}

	@Test
	public void TestCalculateBeanDiscount() {

		Bean bean = new Bean(0.50, 6, "Bean");
		when(shoppingCartImpl.visit(bean)).thenReturn(1.6);

		double total = bean.accept(shoppingCartImpl);
		assertEquals(total, 1.6, PRECISION);

	}

	@Test
	public void TestCalculateCokeDiscount() {

		Coke coke = new Coke(0.70, 10, "Coke");
		when(shoppingCartImpl.visit(coke)).thenReturn(1.7);

		double total = coke.accept(shoppingCartImpl);
		assertEquals(total, 1.7, PRECISION);

	}
}
