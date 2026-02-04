package Tema4;

import java.util.Arrays;

public class BancoPersona {
    private String dni;
    private Cuenta[] cuentas;
    private int contadorCuentas;

    public BancoPersona(){
        this.dni = "";
        this.cuentas = new Cuenta[0];
        this.contadorCuentas = 0;
    }
    public BancoPersona(String dni) {
        this.dni = dni;
        this.cuentas = new Cuenta[3]; // Máximo 3 cuentas
        this.contadorCuentas = 0;
    }

    // Añadir cuentas hasta el máximo
    public boolean anadirCuenta(Cuenta nuevaCuenta) {
        boolean account;
        if (contadorCuentas < 3) {
            cuentas[contadorCuentas] = nuevaCuenta;
            contadorCuentas++;
            account = true;
        } else account = false;
        return account;
    }

    // Detectar si es morosa (alguna cuenta en negativo)
    public boolean esMorosa() {
        boolean morosa = false;
        for (int i = 0; i < contadorCuentas; i++) {

            morosa = cuentas[i].getSaldo() < 0;
        }
        return morosa;
    }

    public String getDni() { return dni; }
    public Cuenta[] getCuentas() { return cuentas; }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCuentas(Cuenta[] cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public String toString() {
        return "DNI: "+this.dni+" Cuentas: "+ Arrays.toString(cuentas) +".";
    }
}
