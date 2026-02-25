package Ejercicio1;

public class Libro {
    private String isbn;
    private String nombre;
    private String autor;
    private  int num_pag;
    private String genero;
    private int peso;
    private String formato;

    public Libro(String isbn, String nombre, String autor) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.autor = autor;
    }


    @Override
    public String toString() {
        return "Libro{" +
                "NOMBRE='" + this.nombre + '\'' +
                ", AUTOR='" + this.autor + '\'' +
                ", num_pag=" + this.peso +
                '}';
    }
    public int pesoLibro(){
        this.peso = 0;
        if (this.formato.trim().equalsIgnoreCase("tapadura")){
            peso = 50 + 2 * this.num_pag;
        } else if (this.formato.trim().equalsIgnoreCase("tapablanda")){
            peso = 20 + 2 * this.num_pag;
        } else if (this.formato.trim().equalsIgnoreCase("debolsillo")) {
            peso = 10 + this.num_pag;
        }
        return peso;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public int getNum_pag() {
        return num_pag;
    }

    public String getGenero() {
        return genero;
    }

    public String getFormato() {
        return formato;
    }

    public void setNum_pag(int num_pag) {
        this.num_pag = num_pag;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}
