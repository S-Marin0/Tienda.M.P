
package com.tienda;

// GUIApp.java
import javax.swing.*;
import java.awt.*;

public class GUIApp implements ShoppingListApp {
    private String buildListText(ListComponent component, String prefix) {
        StringBuilder sb = new StringBuilder();
        if (component instanceof Item item) {
            sb.append(prefix).append(item.quantity).append(" x ")
              .append(item.name).append(" = ").append(item.getPrice()).append("\n");
        } else if (component instanceof Category cat) {
            sb.append(prefix).append("[").append(cat.name).append("]\n");
            for (ListComponent child : cat.children) {
                sb.append(buildListText(child, prefix + "  "));
            }
        }
        return sb.toString();
    }

    @Override
    public void run(Category lista) {
        int contador = 0;
        while (contador < 30) {
            int option = JOptionPane.showConfirmDialog(null, "¿Deseas agregar un producto?", "Agregar", JOptionPane.YES_NO_OPTION);
            if (option != JOptionPane.YES_OPTION) break;

            String categoria = JOptionPane.showInputDialog("Nombre de la categoría:");
            String nombre = JOptionPane.showInputDialog("Nombre del producto:");
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio unitario:"));

            Category nuevaCategoria = new Category(categoria);
            nuevaCategoria.add(new Item(nombre, cantidad, precio));
            lista.add(nuevaCategoria);

            contador++;
        }

        String content = buildListText(lista, "") + "\nTotal: " + lista.getPrice();

        JTextArea textArea = new JTextArea(content);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(null, scrollPane, "Lista de Mercado", JOptionPane.INFORMATION_MESSAGE);
    }
}