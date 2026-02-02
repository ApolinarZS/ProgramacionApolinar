package Tema4;

public class BancoPersona {
    private String dni;
    private Cuenta[] cuentas;
    private int contadorCuentas;

    public BancoPersona(String dni) {
        this.dni = dni;
        this.cuentas = new Cuenta[3]; // Máximo 3 cuentas
        this.contadorCuentas = 0;
    }

    // Añadir cuentas hasta el máximo
    public boolean añadirCuenta(Cuenta nuevaCuenta) {
        if (contadorCuentas < 3) {
            cuentas[contadorCuentas] = nuevaCuenta;
            contadorCuentas++;
            return true;
        }
        return false;
    }

    // Detectar si es morosa (alguna cuenta en negativo)
    public boolean esMorosa() {
        for (int i = 0; i < contadorCuentas; i++) {
            if (cuentas[i].getSaldo() < 0) {
                return true;
            }
        }
        return false;
    }

    public String getDni() { return dni; }
    public Cuenta[] getCuentas() { return cuentas; }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCuentas(Cuenta[] cuentas) {
        this.cuentas = cuentas;
    }
}
