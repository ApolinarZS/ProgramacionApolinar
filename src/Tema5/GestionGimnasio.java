package Tema5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestionGimnasio {

    private static Map<String, Usuario> gimnasio = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        //bucle para mantenernos dentro del programa mientras lo necesitemos
        do {
            menu();
            opcion = sc.nextInt();
            sc.nextLine();

            //switch para las diferentes opciones del programa
            switch (opcion) {
                case 1 -> altaUsuario();
                case 2 -> bajaUsuario();
                case 3 -> consultarUsuario();
                case 4 -> modificarUsuario();
                case 5 -> System.out.println("Cerrando aplicación...");
                default -> System.out.println("Error: Opción no válida.");
            }
        } while (opcion != 0);
    }

    //procedimiento para mostrar el menú
    public static void menu(){
        System.out.println("----BIENVENIDO AL SISTEMA DE ADMINISTRACIÓN DE USUARIOS DE ESTE NUESTRO GIMNASIO----\n" +
                "----SELECCIONA QUÉ ACCIÓN DESEAS REALIZAR----\n" +
                "1) DAR DE ALTA UN USUARIO.\n" +
                "2) DAR DE BAJA UN USUARIO.\n" +
                "3) MOSTRAR LOS DATOS DE UN USUARIO.\n" +
                "4) MODIFICAR UN USUARIO.\n" +
                "5) SALIR");
    }

    //procedimiento para dar de alta a un usuario
    private static void altaUsuario() {
        System.out.print("Introduce DNI: ");
        String dni = sc.nextLine();

        if (gimnasio.containsKey(dni)) {
            System.out.println("Error: Ya existe un usuario con ese DNI.");
        } else {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Edad: ");
            int edad = sc.nextInt();
            gimnasio.put(dni, new Usuario(nombre, edad));
            System.out.println("Usuario registrado con éxito.");
        }
    }

    //procedimiento para dar de baja a un usuario
    private static void bajaUsuario() {
        System.out.print("DNI del usuario a eliminar: ");
        String dni = sc.nextLine();

        if (gimnasio.remove(dni) != null) {
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("Error: No se encontró ningún usuario con DNI " + dni);
        }
    }

    //procedimiento para mostrar la información de un usuario en concreto vía DNI
    private static void consultarUsuario() {
        System.out.print("Introduce DNI a consultar: ");
        String dni = sc.nextLine();

        Usuario u = gimnasio.get(dni);
        if (u != null) {
            System.out.println("Datos del socio [" + dni + "]: " + u);
        } else {
            System.out.println("Error: Usuario no registrado.");
        }
    }

    //función para modificar la información de un usuario vía DNI
    private static void modificarUsuario() {
        System.out.print("Introduce DNI del usuario a modificar: ");
        String dni = sc.nextLine();

        Usuario u = gimnasio.get(dni);
        if (u != null) {
            System.out.println("Datos actuales: " + u);
            System.out.print("Nuevo nombre (pulsa Enter para mantener): ");
            String nuevoNombre = sc.nextLine();
            if (!nuevoNombre.isEmpty()) u.setNombre(nuevoNombre);

            System.out.print("Nueva edad (0 para mantener): ");
            int nuevaEdad = sc.nextInt();
            if (nuevaEdad > 0) u.setEdad(nuevaEdad);

            System.out.println("Datos actualizados correctamente.");
        } else {
            System.out.println("Error: El usuario no existe.");
        }
    }
}
