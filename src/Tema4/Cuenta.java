package Tema4;

public class Cuenta {
    private String numeroCuenta;
    private double saldo;

    public Cuenta(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    // Consultar saldo disponible
    public double getSaldo() {
        return saldo;
    }

    // Recibir abonos
    public void abonar(double cantidad) {
        this.saldo += cantidad;
    }

    // Pagar recibos
    public void pagar(double cantidad) {
        this.saldo -= cantidad;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }
}
