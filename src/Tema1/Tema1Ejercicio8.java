package Tema1;

import java.util.Scanner;

public class Tema1Ejercicio8 {
    public static void main (String[] args){

        //abrimos el escaner y pedimos al usuario el primer y segundo número entero
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el primer número entero");
        int num1 = scanner.nextInt();

        System.out.println("Introduce el segundo número entero");
        int num2 = scanner.nextInt();

        //si el número 1 y 2 son iguales se lo mostramos al usuario
        if (num1 == num2){
            System.out.println("Los dos números enteros introducidos son iguales");

        } else if (num1 > num2){ //comparamos y vemos cuál es el número más alto y lo mostramos
            System.out.println("El número " +num1+ " es mayor a "+num2);
            } else {
            System.out.println("El número " + num2 + " es mayor a " + num1);
        }
    }
}