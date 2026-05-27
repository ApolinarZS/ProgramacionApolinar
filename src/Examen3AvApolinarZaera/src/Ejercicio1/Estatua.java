package Ejercicio1;

public class Estatua extends Figura{
    private String franchise;

    public Estatua (String name, int releaseYear, double basePrice, Status status, String franchise){
        super(name, releaseYear, basePrice, status);
        this.franchise = franchise;
    }

    @Override
    public String toString() {
        return super.toString() + " - Franquicia: " + this.franchise;
    }
}
