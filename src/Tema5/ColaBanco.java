package Tema5;

import java.util.LinkedList;
import java.util.Scanner;

public class ColaBanco {
    // Usamos LinkedList porque permite acceso por índice y comportamiento de cola
    private static LinkedList<UsuarioCola> cola = new LinkedList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarEstadoCola();
            menu();

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> anadirACola();
                case 2 -> atenderPrimero();
                case 3 -> quitarPorPosicion();
                case 0 -> System.out.println("Cerrando sistema de turnos...");
                default -> System.out.println("Error: Opción no válida.");
            }
        } while (opcion != 0);
    }
    public static void menu(){

        System.out.println("\n--- GESTIÓN DE TURNOS ---");
        System.out.println("1. Añadir usuario a la cola (Llegada)");
        System.out.println("2. Atender al primero (Salida)");
        System.out.println("3. Quitar por posición (Abandono)");
        System.out.println("0. Salir");
        System.out.print("Seleccione opción: ");
    }

    private static void mostrarEstadoCola() {
        System.out.println("\n========= COLA ACTUAL =========");
        if (cola.isEmpty()) {
            System.out.println("La cola está vacía.");
        } else {
            for (int i = 0; i < cola.size(); i++) {
                System.out.println((i + 1) + ". " + cola.get(i));
            }
        }
        System.out.println("===============================");
    }

    private static void anadirACola() {
        //leemos a las características de la persona que se añade a la cola
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.print("DNI: ");
        String dni = sc.nextLine();

        UsuarioCola nuevo = new UsuarioCola(nombre, edad, dni);
        cola.addLast(nuevo); // Se añade al final de la lista
        System.out.println("Cliente " + nombre + " ha tomado turno al final de la cola.");
    }

    private static void atenderPrimero() {
        if (!cola.isEmpty()) {
            // pollFirst() quita y devuelve el primer elemento
            UsuarioCola atendido = cola.pollFirst();
            System.out.println("Atendiendo ahora a: " + atendido.getNombre());
        } else {
            System.out.println("No hay clientes esperando.");
        }
    }

    private static void quitarPorPosicion() {
        if (cola.isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }

        System.out.print("Introduce el número de posición que abandona (1-" + cola.size() + "): ");
        int pos = sc.nextInt();

        // Validamos que la posición sea correcta (ajustando índice 0)
        if (pos >= 1 && pos <= cola.size()) {
            UsuarioCola abandonista = cola.remove(pos - 1);
            System.out.println("El cliente " + abandonista.getNombre() + " ha salido de la cola.");
        } else {
            System.out.println("Error: Posición inválida.");
        }
    }
}
