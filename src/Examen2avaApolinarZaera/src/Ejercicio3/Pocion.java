package Examen2avaApolinarZaera.src.Ejercicio3;

class Pocion extends Articulo{
    private int nivel;


    public Pocion(String nombre, boolean gratis, int nivel) {
        super(nombre, gratis);
        this.nivel = nivel;
    }

    @Override
    public void Tipo() {
        System.out.println("Es una poción de nivel "+this.nivel+".");

    }

    @Override
    public int Precio() {
        int valor = 0;
        if (nivel == 1){
            System.out.println("Costará 5 euros");
            valor = 2;
        } else if (nivel == 2){
            System.out.println("Costará 10 euros");
            valor = 5;
        } else if (nivel == 3) {
            System.out.println("Costará 15 euros");
            valor = 10;
        }
        if (gratis){
            valor = 0;
        }
        return valor;
    }

    @Override
    public String toString() {
        return "Pocion{" +
                "nivel=" + nivel +
                ", nombre='" + nombre + '\'' +
                ", gratis=" + gratis +
                '}';
    }
}
