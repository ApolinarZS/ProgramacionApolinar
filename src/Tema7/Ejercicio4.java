package Tema7;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántos nombres de persona deseas generar?: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        System.out.print("¿A qué archivo deseas añadirlos?: ");
        String destino = sc.nextLine();

        try {
            List<String> nombres = Files.readAllLines(Paths.get("usa_nombres.txt"));
            List<String> apellidos = Files.readAllLines(Paths.get("usa_apellidos.txt"));
            List<String> generados = new ArrayList<>();
            Random rnd = new Random();

            for (int i = 0; i < cantidad; i++) {
                String n = nombres.get(rnd.nextInt(nombres.size()));
                String a = apellidos.get(rnd.nextInt(apellidos.size()));
                generados.add(n + " " + a);
            }

            Files.write(Paths.get(destino), generados, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Nombres generados y añadidos correctamente.");
        } catch (Exception e) {
            System.out.println("Error procesando la generación de nombres.");
        }
    }
}
