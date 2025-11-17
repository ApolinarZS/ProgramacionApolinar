package SimulacroExamen;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main (String[] args) {

        //mostramos al usuario el menú
        System.out.println("""
                ¿A qué sección quieres acceder?
                (a) Aprobados y suspendidos
                (b) Billetes a Madrid
                (c) Salir""");

        //leemos y guardamos qué quiere hacer el usuario
        Scanner scanner = new Scanner(System.in);
        String menu = scanner.nextLine();

        //según lo que quiera hacer accederemos a una parte del switch o a otra

        switch (menu){

            case "a"->{

                //Parte 2 del Ejercicio 1, "Dada una secuencia de n notas, decir si hay más aprobados o suspensos".

                //variables que usaremos de contador
                int aprobados = 0, suspendidos = 0;

                //variable que usaremos para notas
                double n; //te faltaría pedir las notas al usuario pero igual vale

                //variable que usaremos como boolean para seguir pidiendo notas
                boolean notas = true;

                System.out.println("Contaremos notas hasta que introduzcas un número negativo, introduce valores válidos, desde el 0 hasta el 10");

                //bucle que usaremos para leer las notas
                do{
                    n = scanner.nextDouble();//leemos notas

                    while (n > 10){//si son mayores de 10 volvemos a pedírselas al usuario

                        System.out.println("Introduce un valor válido, desde el 0 hasta el 10");
                        n = scanner.nextDouble();
                    }

                    if (n >= 5){//aplicamos el contador y sumamos a aprobados o a suspendidos
                        aprobados++;
                    } else if (n < 5 && n > 0) suspendidos++;

                    if (n < 0) notas = false;//si son negativos nos saldremos del bucle

                } while (notas);

                //comprobamos si hay más aprobados o suspendidos y se lo comunicamos al usuario
                if (aprobados > suspendidos){
                    System.out.println("Han habido más aprobados");
                } else if (aprobados < suspendidos) {
                    System.out.println("Han habido más suspendidos");
                } else System.out.println("Han habido la misma cantidad de aprobados y suspendidos");

            }
            case "b"->{
                //Parte 3 del Ejercicio 1

                //variable donde nos dirá el usuario cuantas personas son en su familia
                int nfamilia;

                //variable donde almacenaremos temporalmente el nombre del familiar que iremos sustituyendo constantemente (nos da igual)
                String nombre = "";

                //variable donde almacenaremos temporalmente la edad del familiar
                int edad;

                //variable donde almacenaremos el coste total del viaje familiar
                double costetotal = 0;

                //empezamos, preguntamos al usuario cuantos familiares viajan
                System.out.println("¿Cuántos miembros sois en la familia?");
                nfamilia = scanner.nextInt();
                scanner.nextLine();

                //bucle para pedir los valores que nos interesan de la cantidad de familiares que se nos ha introducido
                for (int i = 1; i <= nfamilia ; i++) {

                    //pedimos el nombre
                    System.out.println("Introduce el nombre");
                    nombre = scanner.nextLine();

                    //pedimos la edad
                    System.out.println("Introduce la edad");
                    edad = scanner.nextInt();
                    scanner.nextLine();

                    //controlamos que el usuario no esté jugando con nosotros, si es una edad irreal, se la volvemos a pedir
                    if (edad < 0 || edad > 120) {
                        System.out.println("Vuelve a introducir la edad por favor");
                        edad = scanner.nextInt();
                        scanner.nextLine();
                    }
                    //segúun la edad introducida, sumamos un valor u otro al coste total
                    if (edad > 15 && edad < 65){
                        System.out.println("La tarifa cuesta 32 euros");
                        costetotal = costetotal + 32;
                    } else if (edad >= 65){
                        System.out.println("Se le descuenta un 10%, la tarifa le costará 28,8 euros");
                        costetotal = costetotal + 28.8;
                    } else if (edad >=12){
                        System.out.println("Se le descuenta un 8%, la tarifa le costará 29,44 euros");
                        costetotal = costetotal + 29.44;
                    } else if (edad >= 4){
                        System.out.println("Se le descuenta un 35%, la tarifa le costará 20,8 euros");
                        costetotal = costetotal + 20.8;
                    } else {
                        System.out.println("Viaja gratis");
                    }
                }
                //Mostramos el resultado al usuario
                System.out.println("-------------------------------------------------------");
                System.out.println("El coste total del viaje será de "+costetotal+" euros.");

            }
            case "c"-> System.out.println("Has salido del menú");

        }
        scanner.close();
    }
}
