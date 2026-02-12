package Tema5;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Gato> listaGatos = new ArrayList<>();

        System.out.println("--- REGISTRO DE 5 GATOS ---");

        while (listaGatos.size() < 5) {
            try {
                System.out.println("\nGato #" + (listaGatos.size() + 1));
                System.out.print("Introduce nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Introduce edad: ");
                int edad = Integer.parseInt(sc.nextLine());

                // Intentar instanciar el gato (puede lanzar Exception)
                Gato nuevoGato = new Gato(nombre, edad);
                listaGatos.add(nuevoGato);
                System.out.println("¡Gato añadido correctamente!");

            } catch (NumberFormatException e) {
                System.err.println("Error: La edad debe ser un número entero.");
                e.printStackTrace();
            } catch (Exception e) {
                // Captura las excepciones lanzadas por la clase Gato
                System.err.println("Error: " + e.getMessage());
                e.printStackTrace(); //
            }
        }

        System.out.println("\n--- LISTADO FINAL DE GATOS ---");
        for (Gato g : listaGatos) {
            System.out.println(g);
        }
    }
}
