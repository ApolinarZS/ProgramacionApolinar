package Tema7;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        List<Alumno> alumnos = new ArrayList<>();

        try (Scanner sc = new Scanner(new File("Documentos/alumnos_notas.txt"))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (linea.trim().isEmpty()) continue;

                String[] datos = linea.split(" ");
                String nombre = datos[0] + " " + datos[1];

                double suma = 0;
                int cantidadNotas = datos.length - 2;
                for (int i = 2; i < datos.length; i++) {
                    suma += Double.parseDouble(datos[i]);
                }

                alumnos.add(new Alumno(nombre, suma / cantidadNotas));
            }

            alumnos.sort((a1, a2) -> Double.compare(a2.notaMedia, a1.notaMedia));

            for (Alumno a : alumnos) {
                System.out.printf("%s - Media: %.2f\n", a.nombreCompleto, a.notaMedia);
            }
        } catch (Exception e) {
            System.out.println("Error procesando el archivo de notas.");
        }
    }
}
