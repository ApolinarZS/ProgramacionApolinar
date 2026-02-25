package Ejercicio3;

class Accesorio extends Articulo{

    private String nombreAccesorio;

    public Accesorio(String nombreAccesorio, String nombre, boolean gratis) {
        super(nombre, gratis);
        this.nombreAccesorio = nombreAccesorio;
    }

    public String getNombreAccesorio() {
        return nombreAccesorio;
    }

    public void setNombreAccesorio(String nombreAccesorio) {
        this.nombreAccesorio = nombreAccesorio;
    }

    @Override
    public void Tipo() {
        System.out.println("Este articulo es un Accesorio, de coste 7 euros);");

    }

    @Override
    public int Precio() {
        int valor;
        if (gratis){
            valor = 0;
        } else {
            System.out.println("El coste del Accesorio es de 7 euros");
            valor = 7;
        }
        return valor;
    }

    @Override
    public String toString() {
        return "Accesorio{" +
                "nombreAccesorio='" + nombreAccesorio + '\'' +
                ", nombre='" + nombre + '\'' +
                ", gratis=" + gratis +
                '}';
    }
}
