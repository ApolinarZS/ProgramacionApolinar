package Tema6;

//Quinta subclase
public class Buho extends Animal {
    public Buho(String nombre) { super(nombre); }

    @Override public void comer() { System.out.println(getNombre() + " come una rata salvaje que acaba de cazar."); }
    @Override public void dormir() { System.out.println("El búho duerme en la rama de un árbol"); }
    @Override public void hacerRuido() { System.out.println("¡Uhú-uhú!"); }

    // Procedimiento único para esta subclase
    public void Cabeza() { System.out.println(getNombre() + " gira la cabeza hasta 270º"); }
}
