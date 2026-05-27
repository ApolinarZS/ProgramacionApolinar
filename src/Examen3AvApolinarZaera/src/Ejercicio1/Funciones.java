package Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Funciones {
    public static void menu() {
        System.out.println("1. Añadir Figura\n 2. Añadir Accesorio \n 3. Mostrar figuras\n 4. Mostrar Funkos Limitados\n 5. Salir");
    }

    public static int menuSelection(Scanner read) {
        int choice = 0;
        try {
            choice = Integer.parseInt(read.nextLine());
        } catch (NumberFormatException e) {
            choice = 0;
        }
        if (choice < 1 || choice > 5) choice = 0;
        return choice;
    }

    //4. Añadir Figura
    public static void addFigure(Scanner read, ArrayList<Figura> figuras) {
        int type = 0;
        try {
            type = Integer.parseInt(read.nextLine());
        } catch (NumberFormatException e) {
            return;
        }
        switch (type) {
            case 1 -> addAction(read, figuras);
            case 2 -> addStatue(read, figuras);
            case 3 -> addFunko(read, figuras);
        }
    }

    private static void addAction(Scanner read, ArrayList<Figura> figuras) {
        try {
            String name = read.nextLine();
            int releaseYear = Integer.parseInt(read.nextLine());
            double basePrice = Double.parseDouble(read.nextLine());
            Status status = pedirEstado(read);
            ArrayList<Accesorio> accesorios = new ArrayList<>();
            figuras.add(new FiguraAccion(name, releaseYear, basePrice, status, accesorios));
        } catch (NumberFormatException e) {
            System.err.println("Error en el formato");
        }
    }

    private static void addStatue(Scanner read, ArrayList<Figura> figuras) {
        try {
            String name = read.nextLine();
            int releaseYear = Integer.parseInt(read.nextLine());
            double basePrice = Double.parseDouble(read.nextLine());
            String franchise = read.nextLine();
            Status status = pedirEstado(read);
            figuras.add(new Estatua(name, releaseYear, basePrice, status, franchise));
        } catch (NumberFormatException e) {
            System.err.println("Error en el formato");
        }
    }

    private static void addFunko(Scanner read, ArrayList<Figura> figuras) {
        try {
            String name = read.nextLine();
            int releaseYear = Integer.parseInt(read.nextLine());
            double basePrice = Double.parseDouble(read.nextLine());
            boolean limitedEdition = Integer.parseInt(read.nextLine()) == 1;
            Status status = pedirEstado(read);
            figuras.add(new Funko(name, releaseYear, basePrice, status, limitedEdition));
        } catch (NumberFormatException e) {
            System.err.println("Error en el formato");
        }
    }

    private static Status pedirEstado(Scanner read) {
        try {
            int type = Integer.parseInt(read.nextLine());
            switch (type) {
                case 1 -> {
                    return Status.PRECINTADA;
                }
                case 3 -> {
                    return Status.SIN_EMBALAJE;
                }
                default -> {
                    return Status.EMBALAJE_ORIGINAL;
                }
            }
        } catch (NumberFormatException e) {
            return Status.EMBALAJE_ORIGINAL;
        }
    }

    //4. Añadir Accesorio
    public static void addAccesory(Scanner read, ArrayList<Figura> figuras){
        String nameToCompare = read.nextLine();
        FiguraAccion figuraEncontrada = null;
        for (Figura figura : figuras){
            if (figura.getName().equalsIgnoreCase(nameToCompare) && figura instanceof FiguraAccion){
                figuraEncontrada = (FiguraAccion) figura;
                break;
            }
        }
        if (figuraEncontrada != null){
            String name = read.nextLine();
            String material = read.nextLine();
            String desc = read.nextLine();
            figuraEncontrada.getAccesories().add(new Accesorio(name, material, desc));
        }
    }

    //Mostrar Listado
    public static void showList ( ArrayList <Figura> figuras){
        for (Figura figura : figuras){
            System.out.println(figura.getName() + " | Precio Real: " + figura.calcRealPrice() + " euros.");
        }
    }

    //Mostrar Funkos de Edición Limitada
    public static void showLimitedFunkos (ArrayList <Figura> figuras){
        for (Figura figura : figuras){
            if (figura instanceof Funko){
                Funko funko = (Funko) figura;
                if (funko.isLimitedEdition()) System.out.println(funko.toString());

            }
        }
    }
}
