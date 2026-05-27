package Ejercicio1;

import java.util.Scanner;
import java.util.ArrayList;

import static Ejercicio1.Funciones.*;

public class Main {
    public static void main(String[] argsn) {

        ArrayList<Figura> figuras = new ArrayList<>();
        Scanner read = new Scanner(System.in);

        menu();
        int choice = menuSelection(read);
        do {
            switch (choice) {
                case 1 -> addFigure(read, figuras);
                case 2 -> addAccesory(read, figuras);
                case 3 -> showList(figuras);
                case 4 ->showLimitedFunkos(figuras);
                case 5 -> System.out.println("Saliste");
            }
        }while (choice != 5);
        
        
    }

}


