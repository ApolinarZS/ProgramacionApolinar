package Tema2;

import java.util.Scanner;

public class Tema2Ejercicio22 {
    public static void main(String[] args) {

        //pedimos el número entero\\
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un número entero");
        int numero = scanner.nextInt();
        int num = numero;
        int digitos = 0;
        //comprobamos y pedimos que el número sea positivo\\
        while (num < 0) {
            System.out.println("Introduce un número positivo");
            num = scanner.nextInt();
        }
        scanner.close();

        //contamos las cifras\\
        while (num != 0){
            num = num / 10;
            digitos++;
        }
        //mostramos por pantalla el resultado\\
        System.out.println("El número "+numero+" tiene "+digitos+" digitos.");
    }
}
