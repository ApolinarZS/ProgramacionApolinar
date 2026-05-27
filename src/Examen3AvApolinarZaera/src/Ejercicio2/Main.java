package Ejercicio2;

import Ejercicio1.Figura;
import Ejercicio1.Funko;

import java.util.ArrayList;
import java.util.Scanner;

import static Ejercicio2.Funciones.*;

public class Main {
    public static void main (String[] args){
        importList();
        Scanner read = new Scanner(System.in);
        ArrayList<Funko> funkoList = new ArrayList<>();

        menu2();
        int choice = menuSelection2(read);
        do {
            switch (choice) {
                case 1 ->{}
                case 2 -> deleteFunko(read, funkoList);
                case 3 ->showNewestFunko(read, funkoList);
                case 4 ->showOldestFunko(read, funkoList);
                case 5 ->showAvgPrice(funkoList);
                case 6 -> System.out.println("Saliste");
            }
        }while (choice != 5);
    }
    public static void menu2() {
        System.out.println("1. Añadir Funko\n 2. Borrar Funko \n 3. Mostrar Funko Más Reciente\n 4. Mostrar Funkos más Antiguo\n 5. Mostrar la Media del Precio Base\n 6. Salir");
    }
    public static int menuSelection2(Scanner read) {
        int choice = 0;
        try {
            choice = Integer.parseInt(read.nextLine());
        } catch (NumberFormatException e) {
            choice = 0;
        }
        if (choice < 1 || choice > 5) choice = 0;
        return choice;
    }
}
