package Tema6;

//Segunda subclase
public class Gato extends Animal {

    public Gato(String nombre) { super(nombre); }

    @Override public void comer() { System.out.println(getNombre() + " come un poco de atún ."); }
    @Override public void dormir() { System.out.println("El gato duerme en un rincon aleatorio."); }
    @Override public void hacerRuido() { System.out.println("Miau"); }

    // Procedimiento único para esta subclase
    public void Ronronear() { System.out.println(getNombre() + " ronronea"); }
}
