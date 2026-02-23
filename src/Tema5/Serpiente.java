package Tema5;

// Subclase Serpiente
class Serpiente extends Avistamiento {
    private double longitud;
    private String especie;

    public Serpiente(int hora, double longitud, String especie) {
        super(hora);
        this.longitud = longitud;
        this.especie = especie;
    }

    @Override
    public String toString() {
        return super.toString() + "SERPIENTE - Especie: " + especie + ", Longitud: " + longitud + "m";
    }
}
