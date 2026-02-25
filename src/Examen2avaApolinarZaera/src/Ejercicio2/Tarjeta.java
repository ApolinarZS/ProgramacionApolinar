package Ejercicio2;

public class Tarjeta implements Dinero{
    private String numero;
    private double saldo;
    private double credito;

    public Tarjeta(String numero, double saldo, double credito) {
        this.numero = numero;
        this.saldo = saldo;
        this.credito = credito;
    }

    @Override
    public double valor() {
        return this.saldo + this.credito;
    }
}
