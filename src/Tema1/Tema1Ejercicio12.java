package Tema1;

import java.util.Scanner;

public class Tema1Ejercicio12 {
    public static void main(String[] args) {

        //abrimos el escaner y pedimos el año que comprobaremos si es o no bisiesto
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un año en números arábigos");
        int num1 = scanner.nextInt();

        //calculamos si es año es bisiesto y se lo mostramos al usuario
        if ((num1 % 4 == 0 && num1 % 100 == 0) || num1 % 400 == 0) {
            System.out.println("El año introducido es bisiesto");
        } else {
            System.out.println("El año introducido no es bisiesto");
        }
    }
}
