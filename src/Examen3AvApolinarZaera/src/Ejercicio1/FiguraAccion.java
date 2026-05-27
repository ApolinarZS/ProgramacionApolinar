package Ejercicio1;

import java.util.ArrayList;
import java.util.Collection;

public class FiguraAccion extends Figura{
    private ArrayList<Accesorio> accesories;

    public FiguraAccion (String name, int releaseYear, double basePrice, Status status, ArrayList<Accesorio> accesories){
        super(name, releaseYear, basePrice, status);
        this.accesories = accesories;
    }

    @Override
    public String toString() {
        return super.toString() + " - Accesorios: " + accesories.toString();
    }

    public Collection<Accesorio> getAccesories() {
        return accesories;
    }
}
