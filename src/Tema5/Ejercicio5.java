package Tema5;

import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Introduce un número para probar las funciones: ");
            int valor = sc.nextInt();

            // Probamos ambas funciones con el mismo valor
            imprimePositivo(valor);
            imprimeNegativo(valor);

        } catch (Exception e) {
            System.err.println("Se ha capturado una excepción: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Imprime p. Lanza excepción si p < 0
    public static void imprimePositivo(int p) throws Exception {
        if (p < 0) {
            throw new Exception("El valor " + p + " no es positivo.");
        }
        System.out.println("Positivo: " + p);
    }

    // Imprime n. Lanza excepción si n >= 0
    public static void imprimeNegativo(int n) throws Exception {
        if (n >= 0) {
            throw new Exception("El valor " + n + " no es negativo.");
        }
        System.out.println("Negativo: " + n);
    }


}
