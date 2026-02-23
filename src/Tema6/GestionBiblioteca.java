package Tema6;

import java.util.ArrayList;

public class GestionBiblioteca {
    public static void main(String[] args) {
        ArrayList<Ficha> catalogo = new ArrayList<>();

        catalogo.add(new Libro(101, "Don Quijote", "Cervantes", "Castalia"));
        catalogo.add(new Revista(202, "National Geographic", 450, 2023));
        catalogo.add(new DVD(303, "Inception", "Christopher Nolan", 2010, "Ciencia Ficción"));

        System.out.println("--- CATÁLOGO DE LA BIBLIOTECA ---");
        for (Ficha f : catalogo) {
            System.out.println(f);
        }
    }
}
