package Tema5;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        // Crear vector de tamaño N (aleatorio entre 1 y 100)
        int n = rnd.nextInt(100) + 1;
        int[] vector = new int[n];

        // Rellenar con valores aleatorios entre 1 y 10
        for (int i = 0; i < vector.length; i++) {
            vector[i] = rnd.nextInt(10) + 1;
        }

        System.out.println("Vector de tamaño " + n + " generado.");

        int posicion = 0;
        // Bucle de consulta hasta introducir valor negativo
        while (posicion >= 0) {
            try {
                System.out.print("Introduce la posición a mostrar (negativo para salir): ");
                posicion = sc.nextInt();

                if (posicion >= 0) {
                    System.out.println("Valor en la posición " + posicion + ": " + vector[posicion]);
                }
            } catch (InputMismatchException e) {
                System.err.println("Error: Debes introducir un número entero.");
                e.printStackTrace(); //
                sc.nextLine(); // Limpiar el buffer
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: La posición introducida no existe.");
                e.printStackTrace(); //
            }
        }
        System.out.println("Fin del programa.");
    }
}
