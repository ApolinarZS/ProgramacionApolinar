package Tema6;

public class Rectangulo extends Figura2D {
    protected double base;
    protected double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override public double area() { return base * altura; }
    @Override public double perimetro() { return 2 * (base + altura); }
    @Override public String toString() { return "Rectángulo [" + base + "x" + altura + "]"; }
}
