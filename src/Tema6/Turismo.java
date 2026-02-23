package Tema6;

// Subclase Turismo
public class Turismo extends Vehiculo{

    private int numPlazas;
        private String uso; // profesional o particular

        public Turismo(String matricula, String marca, int numPlazas, String uso) {
            super(matricula, marca);
            this.numPlazas = numPlazas;
            this.uso = uso;
        }

        @Override
        public String toString() {
            return super.toString() + ", Plazas: " + numPlazas + ", Uso: " + uso;
        }
}
