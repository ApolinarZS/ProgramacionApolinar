package Ejercicio1;

public class Funko extends Figura{
    private boolean limitedEdition;

    public Funko(String name, int releaseYear, double basePrice, Status status, boolean limitedEdition){
        super (name, releaseYear, basePrice, status);
        this.limitedEdition = limitedEdition;
    }

    public boolean isLimitedEdition(){
        return limitedEdition;
    }

    public void setLimitedEdition(boolean limitedEdition) {
        this.limitedEdition = limitedEdition;
    }

    @Override
    public double calcRealPrice(){
        double precioBaseCalculado = super.calcRealPrice();
        int anosAntiguedad = 2026 - this.getReleaseYear();
        return precioBaseCalculado + (anosAntiguedad * 10);
    }

    @Override
    public String toString(){
        String bool = this.limitedEdition ? "Sí" : "No";
        return super.toString() + " - Edición Limitada: " + bool;
    }

}
