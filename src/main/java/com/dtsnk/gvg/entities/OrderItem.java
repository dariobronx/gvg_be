package com.dtsnk.gvg.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    private Product product;
    private int pieces;
    private int expense;
    private int ivaExpense;
    private int totalExpense;
}