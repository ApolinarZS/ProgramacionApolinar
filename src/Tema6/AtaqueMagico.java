package Tema6;

class AtaqueMagico implements Ataque {
    @Override public void lanzar() { System.out.println("¡Lanzando hechizo!"); }
    @Override public int coste() { return 50; }
    @Override public int danoInfligido() { return 120; }
}
