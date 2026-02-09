package Tema5;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Num 1: ");
            int n1 = sc.nextInt();
            System.out.print("Num 2: ");
            int n2 = sc.nextInt();
            System.out.println("Resultado: " + (n1 / n2));
        } catch (java.util.InputMismatchException e) {
            System.err.println("Error: Debes introducir números enteros.");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.err.println("Error: No se puede dividir por cero."); // Mensaje específico
            e.printStackTrace();
        }
    }
}
