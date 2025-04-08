
package com.tienda;

// ShoppingListBuilder.java
import java.util.ArrayDeque;
import java.util.Deque;

public class ShoppingListBuilder {
    private final Category root = new Category("Lista de Mercado");
    private final Deque<Category> stack = new ArrayDeque<>();

    public ShoppingListBuilder() {
        stack.push(root);
    }

    public ShoppingListBuilder addCategory(String name) {
        Category cat = new Category(name);
        stack.peek().add(cat);
        stack.push(cat);
        return this;
    }

    public ShoppingListBuilder addItem(String name, int qty, double price) {
        stack.peek().add(new Item(name, qty, price));
        return this;
    }

    public ShoppingListBuilder endCategory() {
        if (stack.size() > 1) {
            stack.pop();
        }
        return this;
    }

    public Category build() {
        return root;
    }
}