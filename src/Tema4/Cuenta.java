package Tema4;

public class Cuenta {
    private String numeroCuenta;
    private double saldo;

    public Cuenta(){
        this.numeroCuenta = "";
        this.saldo = 0;
    }

    public Cuenta(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    // Consultar saldo disponible
    public double getSaldo() {
        return saldo;
    }

    //setter saldo

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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

    @Override
    public String toString() {
        return "IBAN: "+this.numeroCuenta+"SALDO: "+this.saldo+".";
    }
}
