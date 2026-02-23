package Tema6;

class AtaqueEspadazoEncantado implements AtaqueAvanzado {
    @Override public void lanzar() { System.out.println("¡Corte con espada llameante!"); }
    @Override public String coste() { return "Maná: 40, Esfuerzo Físico: 40"; }
    @Override public String danoInfligido() { return "Mágico: 80, Físico: 80"; }
}
