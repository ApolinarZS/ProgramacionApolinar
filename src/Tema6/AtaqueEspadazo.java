package Tema6;

class AtaqueEspadazo implements AtaqueAvanzado {
    @Override public void lanzar() { System.out.println("¡Corte limpio con la espada!"); }
    @Override public String coste() { return "Maná: 0, Esfuerzo Físico: 50"; }
    @Override public String danoInfligido() { return "Mágico: 0, Físico: 100"; }
}
