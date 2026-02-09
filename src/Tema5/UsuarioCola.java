package Tema5;

public class UsuarioCola {
    private String nombre;
    private int edad;
    private String dni;

    public UsuarioCola(){
        this.nombre ="";
        this.edad = 0;
        this.dni = "";
    }
    public UsuarioCola(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }


    public String getNombre() { return nombre; }
    public String getDni() { return dni; }

    @Override
    public String toString() {
        return String.format("[Nombre: %s | DNI: %s | Edad: %d]", nombre, dni, edad);
    }
}
