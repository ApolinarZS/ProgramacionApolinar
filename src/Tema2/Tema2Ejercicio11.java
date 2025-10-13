package Tema2;

import java.util.Scanner;

public class Tema2Ejercicio11 {
    public static void main (String[]args){

        //Pedimos al usuario los números a ordenar\\
        Scanner numeros = new Scanner(System.in);
        System.out.println("Introduce el valor del primer número");
        double num1 = numeros.nextDouble();
        System.out.println("Introduce el valor del segundo número");
        double num2 = numeros.nextDouble();
        System.out.println("Introduce el valor del tercer número");
        double num3 = numeros.nextDouble();

        //Vemos si son consecutivos y se lo decimos al usuario\\
        if (num1+1 == num2 && num2+1 == num3){
            System.out.println("Los números introducidos son consecutivos");
        } else if ((num1-1 == num2 && num2-1 == num3)){
            System.out.println("Los números introducidos son consecutivos");
        } else System.out.println("Los números introducidos no son consecutivos");

        numeros.close();
    }
}
