package Tema5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double[] vector = new double[5];
        int cont = 0;

        while (cont < 5) {
            try {
                System.out.print("Introduce el valor para la posición " + cont + ": ");
                vector[cont] = sc.nextDouble();
                cont++; // Solo avanzamos si no hay excepción
            } catch (InputMismatchException e) {
                System.err.println("Error: Debes introducir un número decimal válido.");
                e.printStackTrace(); // Mostramos la pila de llamadas
                sc.nextLine(); // Limpiamos el buffer del scanner
            }
        }

        System.out.println("Vector completo.");
    }
}
