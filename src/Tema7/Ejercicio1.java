package Tema7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        //Iniciamos con el valor mínimo y máximo posible del tipo integer
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        try (Scanner sc = new Scanner(new File("Documentos/numeros.txt"))) {
            while (sc.hasNextInt()) {
                int num = sc.nextInt();
                if (num > max) max = num;
                if (num < min) min = num;
            }
            System.out.println("Valor máximo: " + max);
            System.out.println("Valor mínimo: " + min);
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo numeros.txt");
        }
    }
}
