
package com.tienda;

// ConsoleApp.java
import java.util.Scanner;

public class ConsoleApp implements ShoppingListApp {
    @Override
    public void run(Category lista) {
        Scanner scanner = new Scanner(System.in);

        int contador = 0;
        while (contador < 30) {
            System.out.println("¿Deseas agregar un producto? (s/n)");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) break;

            System.out.println("Nombre de la categoría:");
            String categoria = scanner.nextLine();
            System.out.println("Nombre del producto:");
            String nombre = scanner.nextLine();
            System.out.println("Cantidad:");
            int cantidad = Integer.parseInt(scanner.nextLine());
            System.out.println("Precio unitario:");
            double precio = Double.parseDouble(scanner.nextLine());

            Category nuevaCategoria = new Category(categoria);
            nuevaCategoria.add(new Item(nombre, cantidad, precio));
            lista.add(nuevaCategoria);

            contador++;
        }

        lista.print("");
        System.out.println("Total: " + lista.getPrice());
    }
}
