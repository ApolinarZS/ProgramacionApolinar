package Tema6;

//Tercera subclase
public class Gallo extends Animal {
    public Gallo(String nombre) { super(nombre); }

    @Override public void comer() { System.out.println(getNombre() + " come semillas."); }
    @Override public void dormir() { System.out.println("El gallo duerme en su corral."); }
    @Override public void hacerRuido() { System.out.println("¡Kikiriki!"); }

    // Procedimiento único para esta subclase
    public void Amanecer() { System.out.println(getNombre() + " nos anuncia el amaneceer con su increíble kakareo"); }
}
