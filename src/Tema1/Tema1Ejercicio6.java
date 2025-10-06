package Tema1;

import java.util.Scanner;

public class Tema1Ejercicio6 {

    public static void main(String[] args) {

        //abrimos escaner
        Scanner radio = new Scanner(System.in);

        //Pedimos al usuario el valor del radio del círculo
        System.out.println("Introduce el valor del radio del circulo");

        //Calculamos el área del círculo
        double r = radio.nextDouble();
        double a = 3.14 * r * r;

        //mostramos por pantalla el resultado
        System.out.println("El área del círculo es " + a);
    }
}
