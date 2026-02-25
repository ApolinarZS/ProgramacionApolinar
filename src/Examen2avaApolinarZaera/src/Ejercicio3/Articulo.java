package Ejercicio3;

public abstract class Articulo {

    protected String nombre;
    protected boolean gratis;


    public Articulo(String nombre, boolean gratis) {
        this.nombre = nombre;
        this.gratis = gratis;
    }

    public Articulo() {
        nombre = "";
        gratis = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isGratis() {
        return gratis;
    }

    public void setGratis(boolean gratis) {
        this.gratis = gratis;
    }

    protected abstract void Tipo();
    protected abstract int Precio();



}
