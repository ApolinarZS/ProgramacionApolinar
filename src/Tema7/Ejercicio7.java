package Tema7;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la ruta del documento de texto (ej. Libros/libro.txt): ");
        String ruta = sc.nextLine();

        try {
            List<String> lineas = Files.readAllLines(Paths.get(ruta));
            int numLineas = lineas.size();
            int numCaracteres = 0;
            int numPalabras = 0;
            Map<String, Integer> frecuencias = new HashMap<>();

            for (String linea : lineas) {
                numCaracteres += linea.length();
                String[] palabras = linea.toLowerCase().split("\\W+");

                for (String p : palabras) {
                    if (!p.isEmpty()) {
                        numPalabras++;
                        frecuencias.put(p, frecuencias.getOrDefault(p, 0) + 1);
                    }
                }
            }

            List<Map.Entry<String, Integer>> listaFrecuencias = new ArrayList<>(frecuencias.entrySet());
            listaFrecuencias.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            System.out.println("\n--- ESTADÍSTICAS ---");
            System.out.println("Nº de líneas: " + numLineas);
            System.out.println("Nº de palabras: " + numPalabras);
            System.out.println("Nº de caracteres: " + numCaracteres);
            System.out.println("\nLas 10 palabras más comunes:");

            int limite = Math.min(10, listaFrecuencias.size());
            for (int i = 0; i < limite; i++) {
                System.out.println((i + 1) + ". " + listaFrecuencias.get(i).getKey() + " -> " + listaFrecuencias.get(i).getValue() + " veces");
            }

        } catch (Exception e) {
            System.out.println("Error procesando el documento.");
        }
    }
}
