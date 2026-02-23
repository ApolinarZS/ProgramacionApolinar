package Tema5;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class AcortadorURL {
    // Nuestro "diccionario" o tabla hash
    private static Map<String, String> baseDatosUrls = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    private static final String DOMINIO = "https://acortar.link/";

    public static void main(String[] args) {
        int opcion;
        do {

            menu();
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1 -> crearRegistro();
                case 2 -> resolverDireccion();
                case 3 -> borrarRegistro();
                case 4 -> mostrarRegistros();
                case 0 -> System.out.println("Cerrando el acortador...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    // --- MÉTODOS DE LA APLICACIÓN ---

    private static void menu(){
        System.out.println("\n=== ACORTADOR DE URLs ===");
        System.out.println("1. Crear nuevo registro (Acortar URL)");
        System.out.println("2. Resolver dirección (Usar código corto)");
        System.out.println("3. Borrar un registro");
        System.out.println("4. Mostrar todos los registros");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    private static void crearRegistro() {
        System.out.print("Introduce la URL original (ej. https://es.wikipedia.org/wiki/Wikipedia): ");
        String urlOriginal = sc.nextLine();

        String claveCorta;
        // Nos aseguramos de que la clave generada no exista ya en el diccionario (colisión)
        do {
            claveCorta = generarClaveAleatoria(5);
        } while (baseDatosUrls.containsKey(claveCorta));

        // Guardamos la pareja Clave -> Valor en el HashMap
        baseDatosUrls.put(claveCorta, urlOriginal);

        System.out.println("¡URL acortada con éxito!");
        System.out.println("Tu nueva URL es: " + DOMINIO + claveCorta);
        System.out.println("(Código único: " + claveCorta + ")");
    }

    private static void resolverDireccion() {
        System.out.print("Introduce el código único (ej. FQp7Y): ");
        String clave = sc.nextLine();

        // Buscamos en el diccionario (O(1) de complejidad, es decir, inmediato)
        String urlOriginal = baseDatosUrls.get(clave);

        if (urlOriginal != null) {
            System.out.println("Redirigiendo a... " + urlOriginal);
        } else {
            System.out.println("Error: No existe ninguna URL asociada a ese código.");
        }
    }

    private static void borrarRegistro() {
        System.out.print("Introduce el código único del registro a borrar: ");
        String clave = sc.nextLine();

        // El remove devuelve el valor borrado, o null si no existía la clave
        String urlBorrada = baseDatosUrls.remove(clave);

        if (urlBorrada != null) {
            System.out.println("Registro borrado correctamente. (" + urlBorrada + ")");
        } else {
            System.out.println("Error: El código introducido no existe en el sistema.");
        }
    }

    private static void mostrarRegistros() {
        System.out.println("\n--- REGISTROS ALMACENADOS ---");
        if (baseDatosUrls.isEmpty()) {
            System.out.println("El diccionario está vacío.");
        } else {
            // Recorremos las claves y valores del HashMap
            for (Map.Entry<String, String> entrada : baseDatosUrls.entrySet()) {
                System.out.println(DOMINIO + entrada.getKey() + "  ->  " + entrada.getValue());
            }
        }
    }

    // Genera una cadena alfanumérica aleatoria de la longitud especificada
    private static String generarClaveAleatoria(int longitud) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < longitud; i++) {
            int indiceAleatorio = rnd.nextInt(caracteres.length());
            sb.append(caracteres.charAt(indiceAleatorio));
        }

        return sb.toString();
    }
}
