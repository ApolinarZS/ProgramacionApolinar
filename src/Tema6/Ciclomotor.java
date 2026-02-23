package Tema6;

// Subclase Ciclomotor
public class Ciclomotor extends Vehiculo {

    private int cilindrada;

    public Ciclomotor(String matricula, String marca, int cilindrada) {
        super(matricula, marca);
        this.cilindrada = cilindrada;
    }

    // NecesitaCarnet devuelve true o false según la cilindrada del ciclomotor
    public boolean necesitaCarnet() {
        return this.cilindrada >= 125;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cilindrada: " + cilindrada + "cc, Necesita carnet: " + necesitaCarnet();
    }
}
