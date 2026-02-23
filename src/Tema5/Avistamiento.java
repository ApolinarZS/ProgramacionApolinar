package Tema5;

// Clase Base
public abstract class Avistamiento {
    private int hora;

    public Avistamiento(int hora) {
        this.hora = hora;
    }

    public int getHora() { return hora; }

    @Override
    public String toString() {
        return "Hora: " + hora + "h | ";
    }
}






