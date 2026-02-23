package Tema6;

// Clase base con atributos comunes
public class Vehiculo {
    private String matricula;
    private String marca;

    public Vehiculo(String matricula, String marca) {
        this.matricula = matricula;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + ", Marca: " + marca;
    }
}