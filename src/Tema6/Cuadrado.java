package Tema6;

// Un cuadrado es un rectángulo con base y altura iguales
public class Cuadrado extends Rectangulo {
    public Cuadrado(double lado) {
        super(lado, lado);
    }

    @Override public String toString() { return "Cuadrado [Lado: " + base + "]"; }
}
