package Tema1;

import java.util.Scanner;

public class Tema1Ejercicio7 {
    public static void main (String[] args){

        //Abrimos el escaner
        Scanner tirada = new Scanner(System.in);

        //Le pedimos al usuario que introduzca el valor del dado
        System.out.println("Introduce el valor del dado");

        //guardamos el valor en una variable "cara"
        int cara = tirada.nextInt();
        //y creamos una variable "opuesta" que tendrá el valor de la cara opuesta a la introducida
        int opuesta = 0;

        //Controlamos que el valor introducido de la cara sea válido a un dado D6
        if (cara < 1 || cara > 6) {
            System.out.println("El número introducido no corresponde a un dado D6");

        } else {//si el número es válido, calculamos la cara opuesta y mostramos el resultado
            opuesta = 7 - cara;
            System.out.println("La cara opuesta a "+cara+" es "+opuesta+".");
        }
    }
}
