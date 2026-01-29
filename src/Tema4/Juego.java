package Tema4;

import java.util.ArrayList;
import java.util.Random;

public class Juego {
    public static void main(String[] args) {
        Random rnd = new Random();
        // Nuestro personaje principal
        Hero protagonista = new Hero("Arturo", 5, 150, 0, 25, 15);
        int hordasSobrevividas = 0;

        System.out.println("=== COMIENZA LA AVENTURA DE " + protagonista.getName() + " ===");

        while (protagonista.isAlive()) {
            hordasSobrevividas++;
            System.out.println("\n--- Horda número " + hordasSobrevividas + " ---");

            // 1. Crear horda de enemigos (entre 1 y 3) usando ArrayList
            ArrayList<Hero> enemigos = generarEnemigos(rnd);
            System.out.println("Han aparecido " + enemigos.size() + " enemigos más débiles.");

            // 2. Bucle de combate de la horda
            while (!enemigos.isEmpty() && protagonista.isAlive()) {

                // Probabilidad de huida (10%) antes del ataque del protagonista
                for (int i = enemigos.size() - 1; i >= 0; i--) {
                    if (rnd.nextDouble() < 0.10) {
                        System.out.println("¡El enemigo " + enemigos.get(i).getName() + " ha huido de terror!");
                        enemigos.remove(i);
                    }
                }

                if (enemigos.isEmpty()) break;

                // Turno del protagonista: Ataca al primer enemigo de la lista
                Hero objetivo = enemigos.get(0);
                protagonista.attack(objetivo);

                if (!objetivo.isAlive()) {
                    System.out.println("¡" + objetivo.getName() + " ha sido derrotado!");
                    enemigos.remove(0);
                }

                // Turno de los enemigos: Cada uno ataca al protagonista
                for (Hero e : enemigos) {
                    if (protagonista.isAlive()) {
                        e.attack(protagonista);
                    }
                }
            }

            // Post-combate: Probabilidades de recuperación
            if (protagonista.isAlive()) {
                // 0.1% de probabilidad de descansar (0.001)
                if (rnd.nextDouble() < 0.001) {
                    protagonista.rest();
                }
                // 10% de probabilidad de poción (0.10)
                if (rnd.nextDouble() < 0.10) {
                    protagonista.drinkPotion();
                }

                System.out.println("Estado actual: " + protagonista);
            }
        }

        System.out.println("\n========================================");
        System.out.println("GAME OVER - " + protagonista.getName() + " ha caído.");
        System.out.println("Hordas sobrevivientes: " + (hordasSobrevividas - 1));
        System.out.println("========================================");
    }

    // Generamos héroes más débiles
    private static ArrayList<Hero> generarEnemigos(Random rnd) {
        ArrayList<Hero> lista = new ArrayList<>();
        int cantidad = rnd.nextInt(3) + 1; // Entre 1 y 3
        for (int i = 0; i < cantidad; i++) {
            // Atributos reducidos comparados con el protagonista
            lista.add(new Hero("Esbirro_" + i, 1, 40, 0, 12, 5));
        }
        return lista;
    }
}
