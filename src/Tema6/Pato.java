package Tema6;

//Cuarta subclase
public class Pato extends Animal {

    public Pato(String nombre) { super(nombre); }

    @Override public void comer() { System.out.println(getNombre() + " come pan húmedo."); }
    @Override public void dormir() { System.out.println("El pato duerme plácidamente"); }
    @Override public void hacerRuido() { System.out.println("¡Cuac!"); }

    // Procedimiento único para esta subclase
    public void Volar() { System.out.println(getNombre() + " despega y vuela hacia el firmamento"); }
}
