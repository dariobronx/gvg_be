package com.dtsnk.gvg.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	private List<OrderItem> items;
	private int expense;
	private int iva;

	public void update() {
//		expense = 0;
//		iva = 0;
//		for (OrderItem item:items) {
//			expense+=item.getExpense();
//			iva
//		}
	}

	public void addOrderItem(OrderItem item) {
		if (items == null)
			items = new ArrayList<>();
		items.add(item);
		update();
	}

}