package Tema4;

public class Hero {

    private String name; //nombre del héroe
    private int level; //nivel del héroe
    private int health; //vida actual del héroe
    private int maxHealth; //vida máxima del héroe
    private int experience; //experiencia antes de subir de nivel
    private int attack; //ataque del héroe
    private int defense; //defensa del héroe

    private static final int potion_health = 10;
    private static final int rest_health = 50;
    private static final int level_up_health_bonus = 5;
    private static final int level_up_stat_bonus = 1;
    private static final int exp_per_attack = 10;
    private static final int exp_level_up = 50;
    private static final int min_damage = 1;

    //Constructor vacío sin parámetros
    public Hero(){
        this.name = "";
        this.level = 0;
        this.health = 0;
        this.experience = 0;
        this.attack = 0;
        this.defense = 0;
    }

    //Constructor con atributos por parámetro
    public Hero(String name, int level, int health, int experience, int attack, int defense){
        this.name = name;
        this.level = level;
        this.health = health;
        this.maxHealth = health;
        this.experience = experience;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void drinkPotion() {
        System.out.println("¡" + name + " usa una poción!");
        this.health = Math.min(this.health + potion_health, this.maxHealth);
        System.out.println("Vida actual: " + this.health);
    }

    public void rest() {
        System.out.println("¡" + name + " descansa!");
        this.health = Math.min(this.health + rest_health, this.maxHealth);
        System.out.println("Vida recuperada. Salud: " + this.health);
    }


    public String toString(String name, int level, int health, int experience, int attack, int defense) {

        return String.format("----INFORMACIÓN DEL HÉROE----\n" +
                "NOMBRE: " + name + "\n" +
                "NIVEL: " + level + "\n" +
                "VIDA: " + health + "\n" +
                "ATAQUE: " + attack + "\n" +
                "DEFENSA: " + defense + "\n" +
                "EXP: " + experience);
    }

    public void attack(Hero enemigo) {
        // Cálculo de daño: entre 1 y Max(ataque - defensa_enemigo, 10)
        int rawDamage = this.attack - enemigo.getDefense();
        int maxPossibleDamage = Math.max(rawDamage, 10);

        // Generar daño aleatorio entre 1 y el máximo calculado
        int damageDealt = (int) (Math.random() * maxPossibleDamage) + min_damage;

        System.out.println(this.name + " ataca a " + enemigo.getName() + " causando " + damageDealt + " de daño.");
        enemigo.setHealth(Math.max(enemigo.getHealth() - damageDealt, 0));

        // Gestión de experiencia
        this.experience += exp_per_attack;
        if (this.experience >= exp_level_up) {
            levelUp();
            this.experience = 0; // Reiniciamos XP tras subir
        }
    }
    public void levelUp() {
        this.level++;
        this.maxHealth += level_up_health_bonus;
        this.health = this.maxHealth; // Curar al subir de nivel es buena práctica
        this.attack += level_up_stat_bonus;
        this.defense += level_up_stat_bonus;
        System.out.println("¡SUBIDA DE NIVEL! " + name + " ahora es nivel " + level);
    }
    public boolean isAlive() {
        return this.health > 0;
    }

}

