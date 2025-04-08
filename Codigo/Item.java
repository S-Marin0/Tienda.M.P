
package com.tienda;

// Item.java
public class Item implements ListComponent {
    String name;
    int quantity;
    double unitPrice;

    public Item(String name, int quantity, double unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    @Override
    public void add(ListComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(ListComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getPrice() {
        return quantity * unitPrice;
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix + quantity + " x " + name + " = " + getPrice());
    }

    @Override
    public ListComponent clone() {
        return new Item(name, quantity, unitPrice);
    }
}