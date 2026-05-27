package Ejercicio1;

public class Accesorio {
    private String name;
    private String material;
    private String desc;

    //Constructor Vacío
    public Accesorio() {
        this.name = "";
        this.material = "";
        this.desc = "";
    }

    //Constructor
    public Accesorio(String name, String material, String desc) {
        this.name = name;
        this.material = material;
        this.desc = desc;
    }

    //toString que permite mostrar la información del objeto
    @Override
    public String toString() {
        return this.name + "(" + this.material + ") - " + this.desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

