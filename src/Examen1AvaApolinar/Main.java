package Examen1AvaApolinar;

import java.util.Scanner;

public class Main {

    public static void main (String[] args){

        //boolean que controla que el menú siga en marcha mientras el usuario no elija salir
        boolean menu = true;

        //bucle del propio menú
        do{
            char option = readOption();

            switch (option){

                case 'a'-> notas50();


                case 'b'-> plantillaExamen();


                case 'c'->{
                    int nota = examenTest(plantillaExamen());
                    System.out.println("Nota Sobre 10 "+nota);
                }


                case 'd'-> honorifica();


                case 'e'-> {
                    System.out.println("Has salido del menú");
                menu = false;
                }

                default -> System.out.println("No es un valor válido");

            }

        }while (menu);


    }


    //función que muestra el menú y recoge la opción que desea el usuario
    public static char readOption(){

        Scanner sc = new Scanner(System.in);

        System.out.println("""
                ------MENÚ------
                (a) Introducir notas del módulo
                (b) Introducir plantilla del examen
                (c) Corregir un examen
                (d) Introducir notas del ciclo
                (e) Salir""");

        return sc.nextLine().charAt(0);
    }


    //EJERCICIO 2: PROCEDIMIENTO que lee una nota sobre 50 de un número a definir de alumnos
    //y muestra cuantos aprobados hay
    public static void notas50(){

        System.out.println("¿La nota de cuántos estudiantes vas a usar?");
        Scanner sc = new Scanner(System.in);

        int estudiantes = sc.nextInt(); //cantidad de estudiantes
        double notas;//variable donde guardaremos las notas
        int aprobados = 0;//contador de aprobados

        for (int i = 0; i < estudiantes; i++){

                System.out.println("Introduce la nota sobre 50 del estudiante "+(i+1)+".");
                notas = sc.nextInt();

                while (notas < 0 || notas > 50){
                    System.out.println("Por favor introduce una nota válida");
                    notas = sc.nextInt();
                }

                if (notas >= 25){
                    aprobados++;
                }

                System.out.println("Nota del estudiante "+(i+1)+": "+notas+" -> "+(notas * 10 /50));
        }
        System.out.println("Total de aprobados: "+aprobados);

    }


    //EJERCICIO 3: FUNCIÓN O PROCEDIMIENTO que lea del usuario unas respuestas a un examen tipo test de un número de preguntas
    //a definir por el usuario con 4 opciones (a,b,c,d)
    public static char[] plantillaExamen(){

        System.out.println("Introduce la cantidad de preguntas de la plantilla");
        Scanner sc = new Scanner(System.in);

        //leemos la cantidad de respuestas que nos dará
        int cantidad = sc.nextInt();

        //creamos el array con la cantidad de respuestas
        char[] plantilla = new char [cantidad];


        for (int i = 0; i < cantidad; i++){

            System.out.println("Introduce la respuesta para la pregunta "+(i+1)+" ('a','b','c','d').");
            plantilla[i] = sc.next().charAt(0);

            while (plantilla[i] != 'a' && plantilla[i] != 'b' && plantilla[i] != 'c' && plantilla[i] != 'd'){

                System.out.println("Introduce una respuesta válida para la pregunta "+(i+1)+" ('a','b','c','d').");
                plantilla[i] = sc.next().charAt(0);

            }
        }
        System.out.println(plantilla);
        return plantilla;
    }


    //EJERCICIO 4: FUNCIÓN que reciba el ejercicio 3 como plantilla y corrija un examen y devuelva la nota
    //Respuesta correcta suma 1 punto, incorrecta resta 1/3 de punto pasar la nota a sobre 10
    public static int examenTest(char[] plantilla){

        Scanner sc = new Scanner(System.in);

        int correcta = 0;//contador respuestas correctas
        int incorrecta = 0;//contador respuestas incorrectas
        int cantidad = plantilla.length;//la cantidad de las respuestas equivaldrá a las de la plantilla
        char[] examen = new char [cantidad];//creamos el array del examen

        //bucle para
        for (int i = 0; i < cantidad; i++){

            System.out.println("Introduce la respuesta para la pregunta "+(i+1)+" ('a','b','c','d').");
            examen[i] = sc.next().charAt(0);

            while (examen[i] != 'a' && examen[i] != 'b' && examen[i] != 'c' && examen[i] != 'd'){

                System.out.println("Introduce una respuesta válida para la pregunta "+(i+1)+" ('a','b','c','d').");
                examen[i] = sc.next().charAt(0);

            }
        }
        for (int i = 0; i < cantidad; i++){

            if (examen[i] == plantilla[i]){
                correcta++;
            } else incorrecta++;
        }
        int nota = (correcta-(incorrecta/3));
        int nota10 = nota * 10 / cantidad;
        System.out.println("Nota (sobre "+cantidad+")= "+nota);
        return nota10;
    }


    //EJERCICIO 5: PROCEDIMIENTO que lea del usuario un número de estudiantes y permita introducir la nota final (solo una)
    //Debemos mostrar qué estudiantes son aptos para mención honorífica
    public static void honorifica(){

        System.out.println("Introduce la cantidad de estudiantes que evaluaremos si son aptos para mención honorífica");
        Scanner sc = new Scanner(System.in);

        //leemos la cantidad de estudiantes
        int estudiantes = sc.nextInt();

        //creamos el array con la cantidad de notas según cuantos estudiantes
        int[] notaFinal = new int [estudiantes];

        for (int i = 0; i < estudiantes; i++){

            System.out.println("Introduce la nota final para el alumno "+(i+1)+".");
            notaFinal[i] = sc.nextInt();

            while (notaFinal[i] < 0 ||  notaFinal[i] > 10){

                System.out.println("Introduce una nota válida para el alumno "+(i+1)+".");
                notaFinal[i] = sc.next().charAt(0);

            }
        }
        for (int i = 0; i < estudiantes; i++){

            if (notaFinal[i] == 10){
                System.out.println("El estudiante "+(i+1)+" es candidato a mención honorífica");
            }
        }

    }

}
