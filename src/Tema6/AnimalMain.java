package Tema6;

public class AnimalMain {
    public static void main(String[] args) {

        // Array de la clase padre
        Animal[] zoologico = new Animal[5];

        // Llenamos el array con las subclases
        zoologico[0] = new Perro("Leo");
        zoologico[1] = new Gato("Misi");
        zoologico[2] = new Gallo("Mazorca");
        zoologico[3] = new Pato("Peak");
        zoologico[4] = new Buho("");

        System.out.println("--- RECORRIENDO EL ZOOLÓGICO ---");

        // Recorremos el array
        for (Animal a : zoologico) {
            System.out.println("\nVi a un animal llamado: " + a.getNombre());
            System.out.println("Tipo de clase: " + a.getClass().getSimpleName());

            // Ejecutamos métodos comunes (cada uno lo hace a su manera)
            a.hacerRuido();
            a.comer();

            // Comprobar si podemos usar los métodos exclusivos
            // 'instanceof' para saber qué es realmente y hacer un cast
            if (a instanceof Gato) {
                ((Gato) a).Ronronear(); // Solo el gato puede hacer esto
            } else if (a instanceof Pato) {
                ((Pato) a).Volar();   // Solo el pato puede hacer esto
            }
        }
    }
}
