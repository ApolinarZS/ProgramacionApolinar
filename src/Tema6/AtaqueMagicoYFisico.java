package Tema6;

class AtaqueMagicoYFisico implements Ataque {
    @Override public void lanzar() { System.out.println("¡Golpe imbuido en magia!"); }
    @Override public int coste() { return 70; }
    @Override public int danoInfligido() { return 150; }
}