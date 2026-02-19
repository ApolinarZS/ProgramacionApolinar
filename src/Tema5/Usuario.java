package Tema5;

public class Usuario {
    private String nombre;
    private int edad;

    //Constructor vacío
    public Usuario(){
        this.nombre="";
        this.edad=0;
    }
    //Constructor con parámetros
    public Usuario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    //setters y getters de los atributos
    //Edad
    public int getEdad() {return edad;}
    public void setEdad(int edad) {
        //Controlamos la edad que es posible registrar
        if (edad > 100 || edad < 16){
            System.err.println("No pueden matricularse en el gimnasio los usuarios que tengan más de 100 años o sean menores de 16");

        }
    }
    //Nombre
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
