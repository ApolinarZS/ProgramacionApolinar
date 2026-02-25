package Ejercicio3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TiendaPokemonTPV {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Articulo> ticket = new ArrayList<>();

        int opcion = 0;
        do{
            menu();
            try{
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion){
                    case 1-> anadirPocion(sc, ticket);
                    case 2-> anadirPokebola(sc, ticket);
                    case 3-> anadirAccesorio(sc, ticket);
                    case 4-> borrarArticulo(sc, ticket);
                    case 5-> mostrarTicket(ticket);
                    //case 6-> mostrarTotal(ticket);
                    case 7->{
                        System.out.println("Has salido");
                    }
                    default-> System.out.println("Esa opción no existe.");
                }
            } catch (InputMismatchException e){
                System.err.println("Error: Introduce números por favor");
                sc.nextLine();
            }
        }while (opcion != 7);
    }
    private static void menu(){
        System.out.println("Bienvenido a la tienda Pokémon\n" +
                "-Selecciona una opción de las siguientes.\n" +
                "1. Añadir poción al ticket\n" +
                "2. Añadir pokebola al ticket\n" +
                "3. Añadir accesorio al ticket\n" +
                "4. Borrar el artículo del ticket (por posición en el ticket)\n" +
                "5. Mostrar todos los artículos del ticket\n" +
                "6. Mostrar total\n" +
                "7. Salir");
    }
    private static void anadirPocion(Scanner sc, ArrayList<Articulo> ticket){
        String nombre = "Poción";
        System.out.println("De qué nivel quieres la poción?");
        int np = sc.nextInt();
        boolean gratis;
        System.out.println("Es gratis?");
        String esGratis = sc.nextLine().trim().toLowerCase();
        if (esGratis.equalsIgnoreCase("si")){
            gratis = true;
        } else gratis = false;
        System.out.println("Poción añadida");
        ticket.add(new Pocion(nombre, gratis, np));
    }
    private static void anadirPokebola(Scanner sc, ArrayList<Articulo> ticket){
        String nombre = "Pokebola";
        System.out.println("Qué tipo de Pokebola quieres? (Pokeball, Greatball o Ultraball sin acentos)");
        String tp = sc.nextLine().trim().toLowerCase();
        boolean gratis;
        System.out.println("Es gratis?");
        String esGratis = sc.nextLine().trim().toLowerCase();
        if (esGratis.equalsIgnoreCase("si")){
            gratis = true;
        } else gratis = false;
        System.out.println("Pokébola añadida");
        ticket.add(new Pokebola(nombre, gratis,tp));
    }
    private static void anadirAccesorio(Scanner sc, ArrayList<Articulo> ticket){
        String nombre = "Accesorio";
        System.out.println("Cómo quieres llamar a este accesorio?");
        String nacc = sc.nextLine();
        boolean gratis;
        System.out.println("Es gratis?");
        String esGratis = sc.nextLine().trim().toLowerCase();
        if (esGratis.equalsIgnoreCase("si")){
            gratis = true;
        } else gratis = false;
        System.out.println("Accesorio añadida");
        ticket.add(new Accesorio(nombre, nacc,gratis));
    }
    private static void borrarArticulo(Scanner sc, ArrayList<Articulo> ticket){
        if(ticket.isEmpty()){
            System.out.println("No hay nada que eliminar del ticket");
        } else {
            System.out.println("El articulo de qué posición desea borrar?");
            int indice = sc.nextInt();
            ticket.remove(indice);
        }

    }
    private static void mostrarTicket(ArrayList<Articulo> ticket){
        for (Articulo articulo : ticket) {
            System.out.println(articulo);
        }
    }
    /* No he conseguido hacer la opción 6, mostrar el total del coste del ticket
    private static void mostrarTotal(Scanner sc, ArrayList<Articulo> ticket){
        double total = 0;
        for (Articulo articulo : ticket){
            total = total + articulo.getPrecio();
            System.out.println("Coste Total: "+total+"euros");
        }
    }*/
}
