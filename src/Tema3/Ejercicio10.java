package Tema3;

import java.util.Scanner;

import static Tema3.MyMath.*;

public class Ejercicio10 {
    public static void main(String[] args) {

        //hacemos un menú para que le sea claro al usuario
        Scanner scanner = new Scanner(System.in);

        boolean menu = true; //determinará si el programa se repite o no
        do{
            menu();

            char option = scanner.next().charAt(0);//Leemos por consola la opción que elige el usuario

            switch (option){
                case 'a'->{
                    System.out.println("Introduce el radio del círculo.");
                    double radius =scanner.nextDouble();

                    double area = circleArea(radius);
                    double perimeter = circlePerimeter(radius);

                    System.out.println("El área del círculo es "+area+".\n" +
                            "El perímetro del círculo es "+perimeter+".");
                }
                case 'b'->{
                    System.out.println("Introduce el lado del cuadrado.");
                    double side = scanner.nextDouble();

                    double area = squareArea(side);
                    double perimeter = squarePerimeter(side);

                    System.out.println("El área del círculo es "+area+".\n" +
                            "El perímetro del círculo es "+perimeter+".");
                }
                case 'c'->{
                    System.out.println("Introduce el ancho del rectángulo.");
                    double width = scanner.nextDouble();
                    System.out.println("Introduce la altura del rectángulo.");
                    double height = scanner.nextDouble();

                    double area = rectangleArea(width, height);
                    double perimeter = rectanglePerimeter(width, height);

                    System.out.println("El área del círculo es "+area+".\n" +
                            "El perímetro del círculo es "+perimeter+".");
                }
                case 'd'->{
                    System.out.println("Introduce un número y te diré si es primo o no.");
                    int num = scanner.nextInt();

                    while (num < 0){
                        System.out.println("Introduce un número válido (no puede ser menor o igual a 0).");
                        num = scanner.nextInt();
                    }
                    boolean primo = siEsPrimo(num);
                    boolean noprimo = noEsPrimo(num);

                    if (primo) System.out.println("El número introducido es primo.");
                    if (noprimo) System.out.println("El número introducido NO es primo.");
                }
                case 'e'->{
                    System.out.println("Introduce un número entero y te diré cuantas cifras tiene.");
                    int num = scanner.nextInt();

                    int digitos = cifras(num);
                    System.out.println("El número introducido tiene "+digitos+" cifras.");
                }
                case 'f'->{
                    System.out.println("Introduce un número entero y te diré cuantas cifras son pares.");
                    int num = scanner.nextInt();

                    int numpares = pares(num);
                    System.out.println("El número introducido tiene "+numpares+" cifras pares.");
                }
                case 'g'->{
                    System.out.println("Introduce un número entero y te diré cuantas cifras son impares.");
                    int num = scanner.nextInt();

                    int numimpares = impares(num);
                    System.out.println("El número introducido tiene "+numimpares+" cifras impares.");
                }
                case 'h'->{
                    System.out.println("Introduce un número entero y te calcularé su factorial");
                    int num = scanner.nextInt();

                    int numfactorial = factorial(num);
                    System.out.println("El factorial de "+num+" es "+numfactorial+".");
                }
                case 'i'->{
                    System.out.println("Introduce un número entero y te calcularé su factorial de manera recursiva.");
                    int num = scanner.nextInt();

                    int numfactorialR = factorialR(num);
                    System.out.println("El factorial de manera recursiva de "+num+" es "+numfactorialR+".");
                }
                case 'j'->{
                    System.out.println("Introduce el valor de a, b y c. Te diré cuantas soluciones tiene su ecuación de segundo grado");
                    System.out.println("a:");
                    int a = scanner.nextInt();
                    System.out.println("b:");
                    int b = scanner.nextInt();
                    System.out.println("c:");
                    int c = scanner.nextInt();

                    int resultado = ecuacion(a, b, c);
                    if (resultado == 1){
                        System.out.println("La ecuación tiene una solución");
                    } else if (resultado == 2){
                        System.out.println("La ecuación tiene dos soluciones");
                    } else System.out.println("No hay solución real");

                }
                case 'k'->{
                    System.out.println("Introduce un número entero y te diré la suma de sus cifras.");
                    int num = scanner.nextInt();

                    int suma = sumadigitos(num);
                    System.out.println("La suma de las cifras del número introducido es "+suma+".");
                }
                case 'l'->{
                    menu = false;
                    System.out.println("Has salido del menú.");
                }
                default -> System.out.println("Introduce un valor correcto por favor");
            }
        } while (menu);

    }
}
