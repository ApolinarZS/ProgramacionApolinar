package Tema5;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Compra {

    public static void main(String[] args) {

        // Creamos el Scanner fuera del bucle para reutilizarlo
        Scanner sc = new Scanner(System.in);
        Set<String> compra = new HashSet<>();
        boolean continuar = true;

        System.out.println("--- LISTA DE LA COMPRA (Escribe 'salir' para terminar) ---");

        do {
            System.out.print("Introduce un producto: ");
            String producto = sc.nextLine().trim().toLowerCase(); // Limpiamos espacios y pasamos a minúsculas

            if (producto.equals("salir")) {
                continuar = false;
            } else if (producto.isEmpty()) {
                System.out.println("El nombre del producto no puede estar vacío.");
            } else {
                if (!compra.add(producto)) { // add devuelve false si el producto ya estaba en la lista
                    System.out.println("¡Aviso! El producto '" + producto + "' ya estaba en la lista.");
                } else {
                    System.out.println("'" + producto + "' añadido.");
                    System.out.println(compra);
                }
            }

        } while (continuar);

        System.out.println("\nTu lista final es: " + compra);
        sc.close();
    }
}
