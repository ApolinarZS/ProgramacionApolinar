package Tema5;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Compra2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // El Set original: lo que queremos comprar
        Set<String> lista = new HashSet<>();
        // El nuevo Set: lo que ya tenemos físicamente
        Set<String> carro = new HashSet<>();

        int opcion;

        System.out.println("--- GESTOR DE COMPRA ---");

        do {
            System.out.println("\n1. Añadir a la LISTA (planear)");
            System.out.println("2. Meter producto al CARRO (comprar)");
            System.out.println("3. Ver estado (¿Qué falta?)");
            System.out.println("0. Salir");
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Producto para la lista: ");
                    String p = sc.nextLine().trim().toLowerCase();
                    if (!lista.add(p)) System.out.println("Ya estaba en la lista.");
                    else System.out.println("Añadido a la lista.");
                }
                case 2 -> {
                    System.out.print("Producto que echas al carro: ");
                    String p = sc.nextLine().trim().toLowerCase();
                    if (carro.add(p)) System.out.println("Metido en el carro.");
                    else System.out.println("Ya estaba en el carro.");
                }
                case 3 -> {
                    System.out.println("\n--- ESTADO ACTUAL ---");
                    System.out.println("En el carro tienes: " + carro);

                    // Calculamos qué falta usando una copia para no borrar la lista original
                    Set<String> falta = new HashSet<>(lista);
                    falta.removeAll(carro); // Operación de Diferencia

                    if (falta.isEmpty()) {
                        System.out.println("¡Genial! No te falta nada de tu lista.");
                    } else {
                        System.out.println("Te falta por añadir: " + falta);
                    }

                    // Extra: Productos en el carro que NO estaban en la lista (Caprichos)
                    Set<String> caprichos = new HashSet<>(carro);
                    caprichos.removeAll(lista);
                    if (!caprichos.isEmpty()) {
                        System.out.println("Llevas caprichos que no planeaste: " + caprichos);
                    }
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}