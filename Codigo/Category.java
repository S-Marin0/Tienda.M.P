
package com.tienda;

// Category.java
import java.util.ArrayList;
import java.util.List;

public class Category implements ListComponent {
    String name;
    List<ListComponent> children = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    @Override
    public void add(ListComponent component) {
        children.add(component);
    }

    @Override
    public void remove(ListComponent component) {
        children.remove(component);
    }

    @Override
    public double getPrice() {
        return children.stream().mapToDouble(ListComponent::getPrice).sum();
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix + "[" + name + "]");
        for (ListComponent child : children) {
            child.print(prefix + "  ");
        }
    }

    @Override
    public ListComponent clone() {
        Category copy = new Category(name);
        for (ListComponent child : children) {
            copy.add(child.clone());
        }
        return copy;
    }
}