package Tema5;

// Subclase Pájaro
class Pajaro extends Avistamiento {
    private double peso;
    private String especie;

    public Pajaro(int hora, double peso, String especie) {
        super(hora);
        this.peso = peso;
        this.especie = especie;
    }

    @Override
    public String toString() {
        return super.toString() + "PÁJARO - Especie: " + especie + ", Peso: " + peso + "kg";
    }
}
