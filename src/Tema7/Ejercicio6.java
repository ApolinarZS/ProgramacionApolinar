package Tema7;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la secuencia numérica a buscar en Pi: ");
        String objetivo = sc.nextLine();

        try {
            String pi = new String(Files.readAllBytes(Paths.get("Documentos/pi-million.txt")));
            boolean encontrado = false;

            for (int i = 0; i <= pi.length() - objetivo.length(); i++) {
                boolean coincide = true;
                for (int j = 0; j < objetivo.length(); j++) {
                    if (pi.charAt(i + j) != objetivo.charAt(j)) {
                        coincide = false;
                        break;
                    }
                }
                if (coincide) {
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {
                System.out.println("¡La secuencia aparece en el primer millón de decimales de Pi!");
            } else {
                System.out.println("La secuencia NO aparece.");
            }
        } catch (Exception e) {
            System.out.println("Error leyendo el archivo pi-million.txt");
        }
    }
}
