package Tema5;

// Subclase Manada de Lobos
class ManadaLobos extends Avistamiento {
    private int numeroLobos;
    private String observaciones;

    public ManadaLobos(int hora, int numeroLobos, String observaciones) {
        super(hora);
        this.numeroLobos = numeroLobos;
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return super.toString() + "MANADA LOBOS - Cantidad: " + numeroLobos + ", Obs: " + observaciones;
    }
}
