package Tema5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroParque {
    private static List<Avistamiento> avistamientos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {

            menu();
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> registrarAvistamiento();
                case 2 -> mostrarAPartirDeLas8();
                case 3 -> mostrarNocturnos();
                case 4 -> mostrarPorTipo(ManadaLobos.class);
                case 5 -> mostrarPorTipo(Serpiente.class);
                case 6 -> mostrarPorTipo(Pajaro.class);
                case 0 -> System.out.println("Cerrando cuaderno de registro...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void registrarAvistamiento() {
        System.out.println("\n¿Qué animal has avistado?");
        System.out.println("1. Serpiente | 2. Pájaro | 3. Manada de Lobos");
        int tipo = sc.nextInt();

        System.out.print("Hora del avistamiento (0-23): ");
        int hora = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        switch (tipo) {
            case 1 -> {
                System.out.print("Especie de serpiente: ");
                String especie = sc.nextLine();
                System.out.print("Longitud (metros): ");
                double longitud = sc.nextDouble();
                avistamientos.add(new Serpiente(hora, longitud, especie));
            }
            case 2 -> {
                System.out.print("Especie del pájaro: ");
                String especie = sc.nextLine();
                System.out.print("Peso (kg): ");
                double peso = sc.nextDouble();
                avistamientos.add(new Pajaro(hora, peso, especie));
            }
            case 3 -> {
                System.out.print("Número de lobos en la manada: ");
                int num = sc.nextInt();
                sc.nextLine();
                System.out.print("Observaciones: ");
                String obs = sc.nextLine();
                avistamientos.add(new ManadaLobos(hora, num, obs));
            }
            default -> System.out.println("Tipo de animal desconocido.");
        }
        System.out.println("¡Avistamiento registrado!");
    }
    private static void menu(){
        System.out.println("\n--- CUADERNO DEL GUARDABOSQUES ---");
        System.out.println("1. Añadir avistamiento");
        System.out.println("2. Mostrar avistamientos a partir de las 8h");
        System.out.println("3. Mostrar avistamientos nocturnos (20h a 8h)");
        System.out.println("4. Mostrar sólo Manadas de Lobos");
        System.out.println("5. Mostrar sólo Serpientes");
        System.out.println("6. Mostrar sólo Pájaros");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    // --- MÉTODOS DE FILTRADO CON STREAMS ---

    private static void mostrarAPartirDeLas8() {
        System.out.println("\n--- AVISTAMIENTOS DESDE LAS 8:00 ---");
        avistamientos.stream()
                .filter(a -> a.getHora() >= 8)
                .forEach(System.out::println);
    }

    private static void mostrarNocturnos() {
        System.out.println("\n--- AVISTAMIENTOS NOCTURNOS (20:00 - 08:00) ---");
        avistamientos.stream()
                .filter(a -> a.getHora() >= 20 || a.getHora() < 8)
                .forEach(System.out::println);
    }

    private static void mostrarPorTipo(Class<?> claseTipo) {
        System.out.println("\n--- FILTRO POR ESPECIE: " + claseTipo.getSimpleName() + " ---");
        avistamientos.stream()
                .filter(claseTipo::isInstance)
                .forEach(System.out::println);
    }
}
