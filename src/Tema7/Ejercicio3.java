package Tema7;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre del archivo de origen: ");
        String origen = sc.nextLine();
        System.out.print("Introduce el nombre del archivo de destino: ");
        String destino = sc.nextLine();

        try {
            List<String> lineas = Files.readAllLines(Paths.get(origen));
            Collections.sort(lineas);
            Files.write(Paths.get(destino), lineas);
            System.out.println("El archivo se ha ordenado y guardado con éxito.");
        } catch (Exception e) {
            System.out.println("Error de lectura/escritura con los archivos indicados.");
        }
    }
}
