package Tema2;

import java.util.Random;
import java.util.Scanner;

public class ProgramacionEstructurada {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);//abrimos escaner
        Random roll = new Random(); //el roll que usaremos para ataque, regeneración y defensa

        //vamos a preparar las variables que usarán los dos personajes del combate
        //Jugador 1
        String j1_tag;
        int j1_hp = 0, j1_hp_max = 0, j1_atk = 0, j1_def = 0, j1_vel = 0, j1_pc = 0;
        //Jugador 2
        String j2_tag;
        int j2_hp = 0, j2_hp_max = 0, j2_atk = 0, j2_def = 0, j2_vel = 0, j2_pc = 0;

        //variables para el juego
        boolean stats1 = true; //permitirá elegir los stats del jugador 1
        boolean stats2 = true; //permitirá elegir los stats del jugador 2
        boolean juego = true; //controlará que el juego siga mientras no llegue al false al tener algún jugador 0 de vida
        int ronda = 0, accion; //contador para mostrar la ronda en la que estamos
        double  j1_atk_roll, j1_def_roll; //roll de ataque y defensa para el calculo del jugador 1
        double  j2_atk_roll, j2_def_roll; //roll de ataque y defensa para el calculo del jugador 2
        int atk_calc, j1_hp_regen, j2_hp_regen; //calculo de ataque que recibe un jugador, regeneración de vida de ambos jugadores

        //Mostramos interfaz para la elección del usuario 1
        System.out.println("""
                +-------------------+
                |J|U|G|A|D|O|R| |1|
                +-------------------+""");
        System.out.println("JUGADOR 1 - INTRODUCE TU NOMBRE");
        j1_tag = scanner.nextLine();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println(j1_tag + " - INTRODUCE TUS ESTADÍSTICAS");
        System.out.println("Dispones de 500 puntos a distribuir entre tus estadísticas (HP, ATK, DEF, VEL)");
        System.out.println("Disclaimer: Cada estadística tendrá que tener un valor entre 1 y 200");

        //Pido al usuario 1 los valores de las estadísticas y me aseguro de que no sean negativos, no superen 500 en total, ni 200 individualmente\\
        //boolean stats se encargará de asegurarse de que los usuarios no introduzcan más de 500 puntos en total, si usan 500 o menos, seguirá el juego
        while (stats1) {

            //Controlamos que la vida tenga 200 o menos, pero que no introduzcan números negativos
            while (j1_hp == 0) {
                System.out.println("Introduce tu VIDA (HP)");
                j1_hp = scanner.nextInt();
                while (j1_hp > 200 || j1_hp <= 0) {
                    System.out.println("No introduzcas valores negativos, superiores a 200 o iguales a 0");
                    System.out.println("Introduce tu VIDA (HP)");
                    j1_hp = scanner.nextInt();
                }
                j1_pc = j1_hp + j1_pc;
                j1_hp_max = j1_hp;
                System.out.println("Has usado " + j1_pc + " puntos de estadísticas");
            }

            //Controlamos que el ataque tenga 200 o menos, pero que no introduzcan números negativos
            while (j1_atk == 0) {
                System.out.println("Introduce tu ATAQUE (ATK)");
                j1_atk = scanner.nextInt();
                while (j1_atk > 200 || j1_atk <= 0) {
                    System.out.println("No introduzcas valores negativos, superiores a 200 o iguales a 0");
                    System.out.println("Introduce tu ATAQUE (ATK)");
                    j1_atk = scanner.nextInt();
                }
                j1_pc = j1_atk + j1_pc;
                System.out.println("Has usado " + j1_pc + " puntos de estadísticas");
            }

            //Controlamos que la defensa tenga 200 o menos, pero que no introduzcan números negativos
            while (j1_def == 0) {
                System.out.println("Introduce tu DEFENSA (DEF)");
                j1_def = scanner.nextInt();
                while (j1_def > 200 || j1_def <= 0) {
                    System.out.println("No introduzcas valores negativos, superiores a 200 o iguales a 0");
                    System.out.println("Introduce tu DEFENSA (DEF)");
                    j1_def = scanner.nextInt();
                }
                j1_pc = j1_def + j1_pc;
                System.out.println("Has usado " + j1_pc + " puntos de estadísticas");
            }

            //Controlamos que la velocidad tenga 200 o menos, pero que no introduzcan números negativos
            while (j1_vel == 0) {
                System.out.println("Introduce tu VELOCIDAD (VEL)");
                j1_vel = scanner.nextInt();
                while (j1_vel > 200 || j1_vel <= 0) {
                    System.out.println("No introduzcas valores negativos, superiores a 200 o iguales a 0");
                    System.out.println("Introduce tu VELOCIDAD (VEL)");
                    j1_vel = scanner.nextInt();
                }
                j1_pc = j1_vel + j1_pc;
                System.out.println("Has usado " + j1_pc + " puntos de estadísticas");
            }
            //comprobamos el poder que ha usado el usuario, si supera 500 reiniciamos el proceso
            if (j1_pc <= 500){
                System.out.println("JUGADOR 1: TU PODER ES DE " +j1_pc+"!");
                stats1 = false;
            } else {
                System.out.println("HAS USADO MÁS DE 500 PUNTOS DE PODER, VUELVE A INTRODUCIRLOS");
                j1_pc = 0;
                j1_hp = 0;
                j1_atk = 0;
                j1_def = 0;
                j1_vel = 0;
            }
        }
        //interfaz para elección del segundo usuario
        System.out.println("""
                +-------------------+
                |J|U|G|A|D|O|R| |2|
                +-------------------+""");
        System.out.println("JUGADOR 2 - INTRODUCE TU NOMBRE");
        j2_tag = scanner.next();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println(j2_tag + " - INTRODUCE TUS ESTADÍSTICAS");
        System.out.println("Dispones de 500 puntos a distribuir entre tus estadísticas (HP, ATK, DEF, VEL)");
        System.out.println("Disclaimer: Cada estadística tendrá que tener un valor entre 1 y 200");

        while (stats2) {

            while (j2_hp == 0) {
                System.out.println("Introduce tu VIDA (HP)");
                j2_hp = scanner.nextInt();
                while (j2_hp > 200 || j2_hp <= 0) {
                    System.out.println("No introduzcas valores negativos, superiores a 200 o iguales a 0");
                    System.out.println("Introduce tu VIDA (HP)");
                    j2_hp = scanner.nextInt();
                }
                j2_pc = j2_hp + j2_pc;
                j2_hp_max = j2_hp;
                System.out.println("Has usado " + j2_pc + " puntos de estadísticas");
            }

            while (j2_atk == 0) {
                System.out.println("Introduce tu ATAQUE (ATK)");
                j2_atk = scanner.nextInt();
                while (j2_atk > 200 || j2_atk <= 0) {
                    System.out.println("No introduzcas valores negativos, superiores a 200 o iguales a 0");
                    System.out.println("Introduce tu ATAQUE (ATK)");
                    j2_atk = scanner.nextInt();
                }
                j2_pc = j2_atk + j2_pc;
                System.out.println("Has usado " + j2_pc + " puntos de estadísticas");
            }

            while (j2_def == 0) {
                System.out.println("Introduce tu DEFENSA (DEF)");
                j2_def = scanner.nextInt();
                while (j2_def > 200 || j2_def <= 0) {
                    System.out.println("No introduzcas valores negativos, superiores a 200 o iguales a 0");
                    System.out.println("Introduce tu DEFENSA (DEF)");
                    j2_def = scanner.nextInt();
                }
                j2_pc = j2_def + j2_pc;
                System.out.println("Has usado " + j2_pc + " puntos de estadísticas");
            }

            while (j2_vel == 0) {
                System.out.println("Introduce tu VELOCIDAD (VEL)");
                j2_vel = scanner.nextInt();
                while (j2_vel > 200 || j2_vel <= 0) {
                    System.out.println("No introduzcas valores negativos, superiores a 200 o iguales a 0");
                    System.out.println("Introduce tu VELOCIDAD (VEL)");
                    j2_vel = scanner.nextInt();
                }
                j2_pc = j2_vel + j2_pc;
                System.out.println("Has usado " + j2_pc + " puntos de estadísticas");
            }

            if (j2_pc <= 500){
                System.out.println("JUGADOR 1: TU PODER ES DE " +j1_pc+"!");
                stats2 = false;
            } else {
                System.out.println("HAS USADO MÁS DE 500 PUNTOS DE PODER, VUELVE A INTRODUCIRLOS");
                j1_pc = 0;
                j1_hp = 0;
                j1_atk = 0;
                j1_def = 0;
                j1_vel = 0;
            }
        }
        //pequeña interfaz de inicio de pelea, mostrando las stats de los dos usuarios
        System.out.println("""
                +-+-+-+-+-+
                |P|E|L|E|A|
                +-+-+-+-+-+""");
        System.out.println("Jugador 1: " + j1_tag + "\n" +
                "Vida: " + j1_hp + "\n" +
                "Ataque: " + j1_atk + "\n" +
                "Defensa: " + j1_def + "\n" +
                "Velocidad: " + j1_vel);

        for (int i = 0; i <= 4; i++) {
            System.out.println("*");
        }

        System.out.println("Jugador 2: " + j2_tag + "\n" +
                "Vida: " + j2_hp + "\n" +
                "Ataque: " + j2_atk + "\n" +
                "Defensa: " + j2_def + "\n" +
                "Velocidad: " + j2_vel);

        for (int i = 0; i <= 4; i++) {
            System.out.println("*");
        }

        while (juego) {

            ronda++;
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("RONDA " + ronda);
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");


            //El turno del j1 si tiene más velocidad
            if (j1_vel > j2_vel) {
                System.out.println(j1_tag + ",¿qué acción deseas realizar?");
                System.out.println("1.ATACAR || 2.REGENERAR");
                accion = scanner.nextInt();

                switch (accion) {
                    case 1 -> {
                        j1_atk_roll = roll.nextDouble(0.15, 0.5);
                        j2_def_roll = roll.nextDouble(0.07, 0.20);
                        atk_calc = (int) ((j1_atk * j1_atk_roll) * 7 / (j2_def * j2_def_roll));
                        j2_hp = j2_hp - atk_calc;
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(j2_tag + " recibe un ataque de " + atk_calc);
                        if (j2_hp < 0) j2_hp = 0;
                        System.out.println(j2_tag + " tiene " + j2_hp + " puntos de vida");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        if (j2_hp == 0) {
                            System.out.println("""
                                    +-+-+-+
                                    |K|.|O|
                                    +-+-+-+""");
                            System.out.println("¡HA GANADO "+j1_tag+"!");
                            System.out.println("ENHORABUENA");
                            juego = false;
                        }

                    }
                    case 2 -> {
                        j1_hp_regen = roll.nextInt(20, 50);
                        j1_hp = j1_hp + j1_hp_regen;
                        if (j1_hp > j1_hp_max){
                            j1_hp = j1_hp_max;
                        }
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(j1_tag + " regenera " + j1_hp_regen + " puntos de vida");
                        System.out.println("Ahora tiene " + j1_hp + " puntos de vida");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    }
                }
                if (j2_hp > 0) {
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    System.out.println(j2_tag+ ",¿qué acción deseas realizar?");
                    System.out.println("1.ATACAR || 2.REGENERAR");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    accion = scanner.nextInt();

                    switch (accion) {
                        case 1 -> {
                            j2_atk_roll = roll.nextDouble(0.15, 0.5);
                            j1_def_roll = roll.nextDouble(0.07, 0.20);
                            atk_calc = (int) ((j2_atk * j2_atk_roll) * 7 / (j1_def * j1_def_roll));
                            j1_hp = j1_hp - atk_calc;
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println(j1_tag + " recibe un ataque de " + atk_calc);
                            if (j1_hp < 0) j2_hp = 0;
                            System.out.println(j1_tag + " tiene " + j1_hp + " puntos de vida");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            if (j1_hp == 0) {
                                System.out.println("""
                                        +-+-+-+
                                        |K|.|O|
                                        +-+-+-+""");
                                System.out.println("¡HA GANADO "+j2_tag+"!");
                                System.out.println("ENHORABUENA");
                                juego = false;
                            }
                        }
                        case 2 -> {
                            j2_hp_regen = roll.nextInt(20, 50);
                            j2_hp = j2_hp + j2_hp_regen;
                            if (j2_hp > j2_hp_max){
                                j2_hp = j2_hp_max;
                            }
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println(j2_tag + " regenera " + j2_hp_regen + " puntos de vida");
                            System.out.println("Ahora tiene " + j2_hp + " puntos de vida");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        }
                    }
                }
            }

            //El turno del j2 si tiene más velocidad
            if (j2_vel > j1_vel) {
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                System.out.println(j2_tag + ",¿qué acción deseas realizar?");
                System.out.println("1.ATACAR || 2.REGENERAR");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                accion = scanner.nextInt();

                if (j2_hp > 0){
                    switch (accion) {
                        case 1 -> {
                            j2_atk_roll = roll.nextDouble(0.15, 0.5);
                            j1_def_roll = roll.nextDouble(0.07, 0.20);
                            atk_calc = (int) ((j2_atk * j2_atk_roll) * 7 / (j1_def * j1_def_roll));
                            j1_hp = j1_hp - atk_calc;
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println(j1_tag + " recibe un ataque de " + atk_calc);
                            if (j1_hp < 0) j1_hp = 0;
                            System.out.println(j1_tag  + " tiene " + j1_hp + " puntos de vida");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            if (j1_hp == 0) {
                                System.out.println("""
                                        +-+-+-+
                                        |K|.|O|
                                        +-+-+-+""");
                                System.out.println("¡HA GANADO "+j2_tag +"!");
                                System.out.println("ENHORABUENA");
                                juego = false;
                            }

                        }
                        case 2 -> {
                            j2_hp_regen = roll.nextInt(20, 50);
                            j2_hp = j2_hp + j2_hp_regen;
                            if (j2_hp > j2_hp_max){
                                j2_hp = j2_hp_max;
                            }
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println(j2_tag + " regenera " + j2_hp_regen + " puntos de vida");
                            System.out.println("Ahora tiene " + j2_hp + " puntos de vida");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        }
                    }
                }
                if (j1_hp > 0) {
                    System.out.println(j1_tag + ",¿qué acción deseas realizar?");
                    System.out.println("1.ATACAR || 2.REGENERAR");
                    accion = scanner.nextInt();

                    switch (accion) {
                        case 1 -> {
                            j1_atk_roll = roll.nextDouble(0.15, 0.5);
                            j2_def_roll = roll.nextDouble(0.07, 0.20);
                            atk_calc = (int) ((j1_atk * j1_atk_roll) * 7 / (j2_def * j2_def_roll));
                            j2_hp = j2_hp - atk_calc;
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println(j2_tag + " recibe un ataque de " + atk_calc);
                            if (j2_hp < 0) j2_hp = 0;
                            System.out.println(j2_tag + " tiene " + j2_hp + " puntos de vida");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            if (j2_hp == 0) {
                                System.out.println("""
                                        +-+-+-+
                                        |K|.|O|
                                        +-+-+-+""");
                                System.out.println("¡HA GANADO "+j1_tag+"!");
                                System.out.println("ENHORABUENA");
                                juego = false;
                            }

                        }
                        case 2 -> {
                            j1_hp_regen = roll.nextInt(20, 50);
                            j1_hp = j1_hp + j1_hp_regen;
                            if (j1_hp > j1_hp_max){
                                j1_hp = j1_hp_max;
                            }
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println(j1_tag + " regenera " + j1_hp_regen + " puntos de vida");
                            System.out.println("Ahora tiene " + j1_hp + " puntos de vida");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        }

                    }
                }
            }


            if (j1_vel == j2_vel) {
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                System.out.println("¡TENÉIS LA MISMA VELOCIDAD!");
                System.out.println("Se lanzará un dado aleatorio para decidir de quién será el turno");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");

                int turno_aleatorio = roll.nextInt(1, 2);

                if (turno_aleatorio == 1) {
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    System.out.println(j1_tag + ",¿qué acción deseas realizar?");
                    System.out.println("1.ATACAR || 2.REGENERAR");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");

                    accion = scanner.nextInt();

                    switch (accion) {
                        case 1 -> {
                            j1_atk_roll = roll.nextDouble(0.15, 0.5);
                            j2_def_roll = roll.nextDouble(0.07, 0.20);
                            atk_calc = (int) ((j1_atk * j1_atk_roll) * 7 / (j2_def * j2_def_roll));
                            j2_hp = j2_hp - atk_calc;
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println(j2_tag + " recibe un ataque de " + atk_calc);
                            if (j2_hp < 0) j2_hp = 0;
                            System.out.println(j2_tag + " tiene " + j2_hp + " puntos de vida");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            if (j2_hp == 0) {
                                System.out.println("""
                                        +-+-+-+
                                        |K|.|O|
                                        +-+-+-+""");
                                System.out.println("¡HA GANADO "+j1_tag+"!");
                                System.out.println("ENHORABUENA");
                                juego = false;
                            }
                        }
                        case 2 -> {
                            j1_hp_regen = roll.nextInt(20, 50);
                            j1_hp = j1_hp + j1_hp_regen;
                            if (j1_hp > j1_hp_max){
                                j1_hp = j1_hp_max;
                            }
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println(j1_tag + " regenera " + j1_hp_regen + " puntos de vida");
                            System.out.println("Ahora tiene " + j1_hp + " puntos de vida");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        }

                    }
                    if (j2_hp > 0) {
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(j2_tag + ",¿qué acción deseas realizar?");
                        System.out.println("1.ATACAR || 2.REGENERAR");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

                        accion = scanner.nextInt();

                        switch (accion) {
                            case 1 -> {
                                j2_atk_roll = roll.nextDouble(0.15, 0.5);
                                j1_def_roll = roll.nextDouble(0.07, 0.20);
                                atk_calc = (int) ((j2_atk * j2_atk_roll) * 7 / (j1_def * j1_def_roll));
                                j1_hp = j1_hp - atk_calc;
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println(j2_tag + " recibe un ataque de " + atk_calc);
                                if (j1_hp < 0) j1_hp = 0;
                                System.out.println(j1_tag + " tiene " + j1_hp + " puntos de vida");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                if (j1_hp == 0) {
                                    System.out.println("""
                                        +-+-+-+
                                        |K|.|O|
                                        +-+-+-+""");
                                    System.out.println("¡HA GANADO "+j2_tag+"!");
                                    System.out.println("ENHORABUENA");
                                    juego = false;
                                }
                            }
                            case 2 -> {
                                j2_hp_regen = roll.nextInt(20, 50);
                                j2_hp = j2_hp + j2_hp_regen;
                                if (j2_hp > j2_hp_max){
                                    j2_hp = j2_hp_max;
                                }
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println(j2_tag + " regenera " + j2_hp_regen + " puntos de vida");
                                System.out.println("Ahora tiene " + j2_hp + " puntos de vida");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            }
                        }
                    }

                }
                if (turno_aleatorio == 2) {
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    System.out.println(j2_tag + ",¿qué acción deseas realizar?");
                    System.out.println("1.ATACAR || 2.REGENERAR");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    accion = scanner.nextInt();

                    switch (accion) {
                        case 1 -> {
                            j2_atk_roll = roll.nextDouble(0.15, 0.5);
                            j1_def_roll = roll.nextDouble(0.07, 0.20);
                            atk_calc = (int) ((j2_atk * j2_atk_roll) * 7 / (j1_def * j1_def_roll));
                            j1_hp = j1_hp - atk_calc;
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println(j1_tag + " recibe un ataque de " + atk_calc);
                            if (j1_hp < 0) j1_hp = 0;
                            System.out.println(j1_tag + " tiene " + j1_hp + " puntos de vida");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            if (j1_hp == 0) {
                                System.out.println("""
                                        +-+-+-+
                                        |K|.|O|
                                        +-+-+-+""");
                                System.out.println("¡HA GANADO "+j2_tag+"!");
                                System.out.println("ENHORABUENA");
                                juego = false;
                            }

                        }
                        case 2 -> {
                            j2_hp_regen = roll.nextInt(20, 50);
                            j2_hp = j2_hp + j2_hp_regen;
                            if (j2_hp > j2_hp_max){
                                j2_hp = j2_hp_max;
                            }
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            System.out.println(j2_tag + " regenera " + j2_hp_regen + " puntos de vida");
                            System.out.println("Ahora tiene " + j2_hp + " puntos de vida");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        }
                    }
                    if (j1_hp > 0) {
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(j1_tag + ",¿qué acción deseas realizar?");
                        System.out.println("1.ATACAR || 2.REGENERAR");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        accion = scanner.nextInt();
                        switch (accion) {
                            case 1 -> {
                                j1_atk_roll = roll.nextDouble(0.15, 0.5);
                                j2_def_roll = roll.nextDouble(0.07, 0.20);
                                atk_calc = (int) ((j1_atk * j1_atk_roll) * 7 / (j2_def * j2_def_roll));
                                j2_hp = j2_hp - atk_calc;
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println(j2_tag + " recibe un ataque de " + atk_calc);
                                if (j2_hp < 0) j2_hp = 0;
                                System.out.println(j2_tag + " tiene " + j2_hp + " puntos de vida");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                if (j2_hp == 0) {
                                    System.out.println("""
                                        +-+-+-+
                                        |K|.|O|
                                        +-+-+-+""");
                                    System.out.println("¡HA GANADO "+j1_tag+"!");
                                    System.out.println("ENHORABUENA");
                                    juego = false;
                                }
                            }
                            case 2 -> {
                                j1_hp_regen = roll.nextInt(20, 50);
                                j1_hp = j1_hp + j1_hp_regen;
                                if (j1_hp > j1_hp_max){
                                    j1_hp = j1_hp_max;
                                }
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println(j1_tag + " regenera " + j1_hp_regen + " puntos de vida");
                                System.out.println("Ahora tiene " + j1_hp + " puntos de vida");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                            }
                        }
                    }
                }
            }
        }
    }
}
