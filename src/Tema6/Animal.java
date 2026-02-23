package Tema6;

public abstract class Animal {
    private String nombre;

    public Animal(String nombre) { this.nombre = nombre; }

    // Métodos obligatorios para cualquier animal
    public abstract void comer();
    public abstract void dormir();
    public abstract void hacerRuido();

    public String getNombre() { return nombre; }
}






