package Tema6;

public class Revista extends Ficha {
    private int numeroPublicacion;
    private int ano;

    public Revista(int numero, String titulo, int numeroPublicacion, int año) {
        super(numero, titulo);
        this.numeroPublicacion = numeroPublicacion;
        this.ano = ano;
    }

    public Revista(int numero, String titulo) {
        super(numero, titulo);
        this.numeroPublicacion = 0;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Libro{" +getNumero()+'\n'+
                "titulo="+getTitulo()+'\n'+
                "numeroPublicacion='" + this.numeroPublicacion + '\'' +
                ", año='" + this.ano + '\'' +
                '}';
    }

}
