package Ejercicio1;

import Ejercicio3.Articulo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorDeLibros {
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);
        ArrayList<Libro> lista = new ArrayList<>();
        int opcion = 0;
        do{
            menu();
            try{
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion){
                    case 1->{}
                    case 2->{}
                    case 3->{}
                    case 4->{}
                    case 5-> System.out.println("Has salido");
                    default-> System.out.println("Esa opción no existe.");
                }
            } catch (InputMismatchException e){
                System.err.println("Error: Introduce números por favor");
                sc.nextLine();
            }
        }while (opcion != 5);
    }
    public static void menu(){
        System.out.println("(1) Introducir un libro.\n" +
                "(2) Mostrar información de un libro (por ISBN).\n" +
                "(3) Modificar el género de un libro (por ISBN).\n" +
                "(4) Buscar todos los libros de un autor.\n" +
                "(5) Salir.\n");
    }
}
