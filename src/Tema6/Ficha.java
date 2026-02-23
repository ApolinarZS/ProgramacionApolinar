package Tema6;

public abstract class Ficha {

    private int numero; // Identificador único
    private String titulo; // Título de la obra

    public Ficha(int numero, String titulo) {
        this.numero = numero;
        this.titulo = titulo;
    }

    // Getters
    public int getNumero() { return numero; }
    public String getTitulo() { return titulo; }
    //Setters
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public abstract String toString(); // Obligamos a las subclases a presentarse


}