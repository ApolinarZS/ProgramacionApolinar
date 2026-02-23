package Tema6;

public class DVD extends Ficha {
    private String director;
    private int ano;
    private String tipo;

    public DVD(int numero, String titulo, String director, int ano, String tipo) {
        super(numero, titulo);
        this.director = director;
        this.ano = ano;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return String.format("[DVD #%d] %s - Dir: %s (%d) | Género: %s",
                getNumero(), getTitulo(), director, ano, tipo);
    }
}
