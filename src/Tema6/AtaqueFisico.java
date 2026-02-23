package Tema6;

class AtaqueFisico implements Ataque {
    @Override public void lanzar() { System.out.println("¡Dando un golpe cuerpo a cuerpo!"); }
    @Override public int coste() { return 20; }
    @Override public int danoInfligido() { return 80; }
}
