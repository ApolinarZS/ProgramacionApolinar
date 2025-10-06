package Tema2;

import java.util.Scanner;

public class Tema2Ejercicio10 {
    public static void main (String[]args){

        //Pedimos al usuario los números a ordenar\\
        Scanner numeros = new Scanner(System.in);
        System.out.println("Introduce el valor del primer número");
        double num1 = numeros.nextDouble();
        System.out.println("Introduce el valor del segundo número");
        double num2 = numeros.nextDouble();
        System.out.println("Introduce el valor del tercer número");
        double num3 = numeros.nextDouble();

        //Vemos si están ordenados de menor a mayor y se lo decimos al usuario\\
        if (num1<num2 || num2<num3){
            System.out.println("Los números introducidos están ordenados de menor a mayor");
        } else System.out.println("Los números introducidos no están ordenados de menor a mayor");

        numeros.close();
    }
}

