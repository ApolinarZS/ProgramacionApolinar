package Tema4;

public class HeroMain {
    public static void main(String[] args) {

        // Creamos dos héroes
        Hero arturo = new Hero("Arturo", 1, 100, 0, 20, 10);
        Hero malvado = new Hero("Orco", 1, 80, 0, 15, 5);

        System.out.println("--- ESTADO INICIAL ---");
        System.out.println(arturo);
        System.out.println(malvado);

        // Arturo ataca varias veces para subir de nivel
        System.out.println("\n--- COMIENZA EL DUELO ---");
        for (int i = 0; i < 5; i++) {
            arturo.attack(malvado);
        }

        // Mostrar estado tras el combate y subida de nivel
        System.out.println("\n--- TRAS EL COMBATE ---");
        System.out.println(arturo);
        System.out.println(malvado);

        // Usar poción y descanso
        malvado.drinkPotion();
        malvado.rest();

        System.out.println("\n--- ESTADO FINAL ---");
        System.out.println(malvado);
    }
}
