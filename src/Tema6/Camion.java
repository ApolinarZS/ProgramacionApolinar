package Tema6;

// Subclase Camion
public class Camion extends Vehiculo {

    private double pesoMaximo;
    private boolean mercanciaPeligrosa;

    public Camion(String matricula, String marca, double pesoMaximo, boolean mercanciaPeligrosa) {
        super(matricula, marca);
        this.pesoMaximo = pesoMaximo;
        this.mercanciaPeligrosa = mercanciaPeligrosa;
    }

    @Override
    public String toString() {
        return super.toString() + ", PMA: " + pesoMaximo + "kg, Peligroso: " + mercanciaPeligrosa;
    }
}