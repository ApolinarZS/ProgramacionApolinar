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
            menu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    anadirLista(sc, lista);
                }
                case 2 -> {
                    meterCarro(sc, carro);
                }
                case 3 -> {
                    estado(lista, carro);
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 0);



        sc.close();
    }
    private static void menu(){
        System.out.println("\n1. Añadir a la LISTA (planear)");
        System.out.println("2. Meter producto al CARRO (comprar)");
        System.out.println("3. Ver estado (¿Qué falta?)");
        System.out.println("0. Salir");
        System.out.print("Seleccione opción: ");
    }
    private static void anadirLista(Scanner sc, Set<String> lista){
        System.out.print("Producto para la lista: ");
        String p = sc.nextLine().trim().toLowerCase();
        if (!lista.add(p)) System.out.println("Ya estaba en la lista.");
        else System.out.println("Añadido a la lista.");
    }
    private static void meterCarro(Scanner sc, Set<String> carro){
        System.out.print("Producto que echas al carro: ");
        String p = sc.nextLine().trim().toLowerCase();
        if (carro.add(p)) System.out.println("Metido en el carro.");
        else System.out.println("Ya estaba en el carro.");
    }
    private static void estado(Set<String> lista, Set<String> carro){
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
    }

}