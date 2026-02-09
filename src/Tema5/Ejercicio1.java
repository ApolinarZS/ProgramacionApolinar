package Tema5;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Introduce un entero: ");
            int num = sc.nextInt(); // Lanza InputMismatchException si no es entero
            System.out.println("Valor introducido: " + num);
        } catch (java.util.InputMismatchException e) {
            System.err.println("Valor introducido incorrecto");
            e.printStackTrace(); // Mostrar pila de llamadas
        }
    }
}
