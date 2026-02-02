package Tema4;

import java.util.ArrayList;
import java.util.Scanner;

public class PruebaCuentas {
    // Almacenamos objetos de tipo BancoPersona
    private static ArrayList<BancoPersona> clientes = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            imprimirMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> registrarPersona();
                case 2 -> vincularCuenta();
                case 3 -> consultarDatos();
                case 4 -> procesarNomina();
                case 5 -> procesarPago();
                case 6 -> transferir();
                case 7 -> listarMorosos();
                case 0 -> System.out.println("Cerrando aplicación...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void imprimirMenu() {
        System.out.println("\n--- MENÚ BANCO ---");
        System.out.println("1. Instanciar BancoPersona");
        System.out.println("2. Instanciar Cuenta y asociar");
        System.out.println("3. Mostrar datos por DNI");
        System.out.println("4. Recibir nómina");
        System.out.println("5. Pagar recibo");
        System.out.println("6. Transferencia entre cuentas");
        System.out.println("7. Imprimir morosos");
        System.out.println("0. Salir");
        System.out.print("Elija: ");
    }

    private static void registrarPersona() {
        System.out.print("DNI del nuevo cliente: ");
        clientes.add(new BancoPersona(sc.nextLine()));
        System.out.println("Cliente registrado.");
    }

    private static void vincularCuenta() {
        BancoPersona p = buscarPorDni();
        if (p != null) {
            System.out.print("Número de cuenta: ");
            String num = sc.nextLine();
            System.out.print("Saldo inicial: ");
            double saldo = sc.nextDouble();
            if (p.añadirCuenta(new Cuenta(num, saldo))) {
                System.out.println("Cuenta vinculada correctamente.");
            } else {
                System.out.println("Límite de 3 cuentas alcanzado.");
            }
        }
    }

    private static void consultarDatos() {
        BancoPersona p = buscarPorDni();
        if (p != null) {
            System.out.println("Cliente DNI: " + p.getDni());
            for (Cuenta c : p.getCuentas()) {
                if (c != null) {
                    System.out.println(" - IBAN: " + c.getNumeroCuenta() + " | Saldo: " + c.getSaldo());
                }
            }
        }
    }

    private static void procesarNomina() {
        BancoPersona p = buscarPorDni();
        if (p != null) {
            System.out.print("IBAN para ingreso: ");
            String iban = sc.nextLine();
            System.out.print("Cuantía nómina: ");
            double cantidad = sc.nextDouble();
            Cuenta c = encontrarCuentaEnPersona(p, iban);
            if (c != null) {
                c.abonar(cantidad);
                System.out.println("Nómina abonada.");
            }
        }
    }

    private static void procesarPago() {
        BancoPersona p = buscarPorDni();
        if (p != null) {
            System.out.print("IBAN para pago: ");
            String iban = sc.nextLine();
            System.out.print("Importe recibo: ");
            double importe = sc.nextDouble();
            Cuenta c = encontrarCuentaEnPersona(p, iban);
            if (c != null) {
                c.pagar(importe);
                System.out.println("Recibo pagado.");
            }
        }
    }

    private static void transferir() {
        System.out.println("EMISOR:");
        BancoPersona emisor = buscarPorDni();
        System.out.println("RECEPTOR:");
        BancoPersona receptor = buscarPorDni();

        if (emisor != null && receptor != null) {
            System.out.print("IBAN Origen: ");
            String ibanOri = sc.nextLine();
            System.out.print("IBAN Destino: ");
            String ibanDest = sc.nextLine();
            System.out.print("Monto: ");
            double monto = sc.nextDouble();

            Cuenta c1 = encontrarCuentaEnPersona(emisor, ibanOri);
            Cuenta c2 = encontrarCuentaEnPersona(receptor, ibanDest);

            if (c1 != null && c2 != null) {
                c1.pagar(monto);
                c2.abonar(monto);
                System.out.println("Transferencia realizada.");
            }
        }
    }

    private static void listarMorosos() {
        System.out.println("CLIENTES CON SALDO NEGATIVO:");
        for (BancoPersona p : clientes) {
            if (p.esMorosa()) {
                System.out.println("- " + p.getDni());
            }
        }
    }

    // Métodos de búsqueda
    private static BancoPersona buscarPorDni() {
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        for (BancoPersona p : clientes) {
            if (p.getDni().equalsIgnoreCase(dni)) return p;
        }
        System.out.println("Cliente no encontrado.");
        return null;
    }

    private static Cuenta encontrarCuentaEnPersona(BancoPersona p, String iban) {
        for (Cuenta c : p.getCuentas()) {
            if (c != null && c.getNumeroCuenta().equals(iban)) return c;
        }
        System.out.println("Cuenta no encontrada en este cliente.");
        return null;
    }
}