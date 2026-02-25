package Ejercicio3;

class Pokebola extends Articulo{
    private String tipoBola;

    public Pokebola(String nombre, boolean gratis, String tipoBola) {
        super(nombre, gratis);
        this.tipoBola = tipoBola;
    }
    @Override
    protected void Tipo() {
        System.out.println("Esto es una Pokebola de tipo:" + this.tipoBola+".");

    }

    @Override
    public int Precio() {
        int valor = 0;
        if (tipoBola.equals("pokeball")){
            System.out.println("Costará 5 euros");
            valor = 2;
        } else if (tipoBola.equals("greatball")){
            System.out.println("Costará 10 euros");
            valor = 5;
        } else if (tipoBola.equals("ultraball")) {
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
        return "Pokebola{" +
                "tipoBola='" + tipoBola + '\'' +
                ", nombre='" + nombre + '\'' +
                ", gratis=" + gratis +
                '}';
    }
}
