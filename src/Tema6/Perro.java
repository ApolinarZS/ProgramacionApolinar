package Tema6;

//Primera subclase
public class Perro extends Animal {

    public Perro(String nombre) { super(nombre); }

    @Override public void comer() { System.out.println(getNombre() + " come las sobras de un estofado."); }
    @Override public void dormir() { System.out.println("El perro duerme en su caseta."); }
    @Override public void hacerRuido() { System.out.println("¡Guau!"); }

    // Procedimiento único para esta subclase
    public void EnterrarHueso() { System.out.println(getNombre() + " está enterrando un hueso."); }
}
