package Tema6;
import Tema6.Ficha;

public class Libro extends Ficha {
    private String autor;
    private String editorial;

    public Libro(int numero, String titulo, String autor, String editorial) {
        super(numero, titulo);
        this.autor = autor;
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro{" +getNumero()+'\n'+
                "titulo="+getTitulo()+'\n'+
                "autor='" + this.autor + '\'' +
                ", editorial='" + this.editorial + '\'' +
                '}';
    }
}
