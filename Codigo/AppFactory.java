
package com.tienda;

// AppFactory.java
public class AppFactory {
    public static ShoppingListApp getApp(String tipo) {
        return switch (tipo) {
            case "1" -> new ConsoleApp();
            case "2" -> new GUIApp();
            default -> throw new IllegalArgumentException("Opción inválida");
        };
    }
}