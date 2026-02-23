package Tema6;

class AtaqueBolaFuego implements AtaqueAvanzado {
    @Override public void lanzar() { System.out.println("¡Bola de fuego gigante!"); }
    @Override public String coste() { return "Maná: 100, Esfuerzo Físico: 5"; }
    @Override public String danoInfligido() { return "Mágico: 200, Físico: 10"; }
}
