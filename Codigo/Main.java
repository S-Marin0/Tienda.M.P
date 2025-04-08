
package com.tienda;

// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingListBuilder builder = new ShoppingListBuilder();
        Category lista = builder.build();

        System.out.println("¿Cómo deseas ver la lista? (1: Consola, 2: Ventana)");
        Scanner scanner = new Scanner(System.in);
        String opcion = scanner.nextLine();

        try {
            ShoppingListApp app = AppFactory.getApp(opcion);
            app.run(lista);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
