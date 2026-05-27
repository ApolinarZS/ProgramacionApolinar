package Ejercicio1;

public abstract class Figura {
    private String name;
    private int releaseYear;
    private double basePrice;
    private Status status;

    //Constructor vacío
    public Figura (){
        this.name = "";
        this.releaseYear = 0;
        this.basePrice = 0;
        this.status = Status.PRECINTADA;
    }

    //Constructor
    public Figura (String name, int releaseYear, double basePricePrice, Status status){
        this.name = name;
        this.releaseYear = releaseYear;
        this.basePrice = basePrice;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double calcRealPrice(){
        if (this.status == Status.PRECINTADA) return this.basePrice * 2;
        else if  (this.status == Status.EMBALAJE_ORIGINAL) return this.basePrice;
        else return this.basePrice/2;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.releaseYear + ") - Precio: " + this.basePrice + "euros - Estado: " +this.status;
    }
}

