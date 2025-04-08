
package com.tienda;

// ListComponent.java
public interface ListComponent extends Cloneable {
    void add(ListComponent component);
    void remove(ListComponent component);
    double getPrice();
    void print(String prefix);
    ListComponent clone();
}