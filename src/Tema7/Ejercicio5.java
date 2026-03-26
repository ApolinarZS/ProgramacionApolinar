package Tema7;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Ejercicio5 {
    public static void main(String[] args) {
        File dir = new File("Diccionario");
        if (!dir.exists()) dir.mkdir();

        try {
            List<String> palabras = Files.readAllLines(Paths.get("Documentos/diccionario.txt"));
            PrintWriter[] escritores = new PrintWriter[26];

            for (int i = 0; i < 26; i++) {
                char letra = (char) ('A' + i);
                escritores[i] = new PrintWriter(new File(dir, letra + ".txt"));
            }

            for (String palabra : palabras) {
                if (palabra.trim().isEmpty()) continue;
                char primeraLetra = Character.toUpperCase(palabra.charAt(0));

                if (primeraLetra >= 'A' && primeraLetra <= 'Z') {
                    escritores[primeraLetra - 'A'].println(palabra);
                }
            }

            for (PrintWriter pw : escritores) {
                pw.close();
            }
            System.out.println("Archivos generados correctamente en la carpeta Diccionario.");
        } catch (Exception e) {
            System.out.println("Error gestionando los archivos del diccionario.");
        }
    }
}
