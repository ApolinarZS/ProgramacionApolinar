package SimulacroExamen;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main (String[] args){

        //abrimos el escaner
        Scanner scanner = new Scanner(System.in);
        //variables para las horas y los minutos
        int horas, minutos;

        //variable que usaremos para saber si el usuario seguirá usando el programa
        boolean menu = true;

        //variable para saber a qué día de la semana está el usuario
        String dia;
        //variable para saber el país
        String pais;

        //bucle del programa
        do {
            //pedimos las horas
            System.out.println("Introduce las horas y minutos");
            horas = scanner.nextInt();
            //controlamos que sea una hora válida
            while (horas < 0 || horas > 23){
                System.out.println("Introduce una hora válida, desde 0 hasta 23");
                horas = scanner.nextInt();
            }

            minutos = scanner.nextInt();
            //controlamos que sean unos minutos válidos
            while (minutos < 0 || minutos > 59){
                System.out.println("Introduce unos minútos válidos, desde 0 hata 59");
                minutos = scanner.nextInt();
            }
            scanner.nextLine();
            //pedimos el día de la semana
            System.out.println("Introduce el día de la semana en minúsculas por favor");
            dia = scanner.nextLine();

            //pedimos el pais de referencia de horario origen
            System.out.println("Introduce el país origen (españa o japon), en minúsculas y sin acentos por favor");
            pais = scanner.nextLine();

            switch (pais){

                case "españa"->{

                    horas = horas + 8;
                    if (horas >= 24){
                        horas = horas - 24;
                        switch (dia){
                            case "lunes"->
                                    dia = "martes";

                            case "martes"->
                                    dia = "miercoles";

                            case "miercoles"->
                                    dia = "jueves";

                            case "jueves"->
                                    dia = "viernes";

                            case "viernes"->
                                    dia = "sabado";

                            case "sabado"->
                                    dia = "domingo";

                            case "domingo"->
                                    dia = "lunes";
                        }
                    }
                    System.out.println("Japón "+horas+":"+minutos+" "+dia+".");
                }

                case "japon"->{
                    horas = horas - 8;
                    if (horas <= 24){ //todo:ermmmm,,,,, debería ser un signo de mayor en vez de menor.......
                        horas = horas + 24;//todo:aparte de eso no tienes ningún fallo bien hecho rey
                        switch (dia){
                            case "lunes"->
                                    dia = "domingo";

                            case "martes"->
                                    dia = "lunes";

                            case "miercoles"->
                                    dia = "martes";

                            case "jueves"->
                                    dia = "miercoles";

                            case "viernes"->
                                    dia = "jueves";

                            case "sabado"->
                                    dia = "viernes";

                            case "domingo"->
                                    dia = "sabado";

                        }
                    }
                    System.out.println("España "+horas+":"+minutos+" "+dia+".");
                }

            }
            //preguntamos al usuario si querrá seguir usando el programa
            System.out.println("Si quieres seguir usando el programa introduce 'seguir'\n" +
                    "Si quieres dejar de usar el programa escribe 'exit'");
            String option = scanner.nextLine();
            //controlamos la elección
            if (option.equals("exit")){
                System.out.println("Has salido del programa");
                menu = false;
            }

        }while (menu);
    }
}
