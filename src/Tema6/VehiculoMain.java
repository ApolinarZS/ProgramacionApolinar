package Tema6;

public class VehiculoMain {

    public static void main(String[] args) {

        // Array de la clase padre
        Vehiculo[] garaje = new Vehiculo[4];

        // Llenamos el garaje con diferentes instancias

        // Un Turismo
        garaje[0] = new Turismo("1234-BCD", "Toyota Corolla", 5, "Particular");

        // Un Camión
        garaje[1] = new Camion("9876-ZZZ", "Volvo FH", 18000.5, true);

        // Un Ciclomotor potente
        garaje[2] = new Ciclomotor("5555-XYZ", "Vespa Primavera", 125);

        // Un Ciclomotor pequeño
        garaje[3] = new Ciclomotor("1111-AAA", "Derbi Variant", 49);

        System.out.println("--- ESTADO DEL GARAJE ---");

        // Recorremos el array
        for (Vehiculo v : garaje) {
            //Hacemos uso del toString
            System.out.println(v);

            // Separador visual
            System.out.println("-------------------------------------------------");
        }
    }
}
