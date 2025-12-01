package Tema3;

public class MyMath {
    public static void menu(){
        System.out.println("""
                    ---------MENÚ---------ª
                    a) Calcular el perímetro y el área de un circulo
                    b) Calcular el perímetro y el área de un cuadrado
                    c) Calcula el área y perímetro de un rectángulo
                    d) Comprobar si un número entero es o no primo
                    e) Comprobar cuantas cifras tiene un número entero
                    f) Comprobar cuantas cifras PARES tiene un número entero
                    g) Comprobar cuantas cifras IMPARES tiene un número entero
                    h) Calcular el factorial de un número entero
                    i) Calcular el factorial de un número de manera recursiva
                    j) Calcular cuantas soluciones tiene una ecuación de segundo grado
                    k) Calcular la suma de las cifras de un número entero
                    l) SALIR""");
    }

    public static double circlePerimeter (double radius){
        return 2 * 3.14 * radius;
    }

    public static double circleArea (double radius){
        return 3.14 * radius * radius;
    }

    public static double squarePerimeter (double side){
        return 4 * side;
    }

    public static double squareArea (double side){
        return side * side;
    }

    public static double rectanglePerimeter (double width, double height){
        return (2 * width) + (2 * height);
    }

    public static double rectangleArea (double width, double height){
        return width * height;
    }

    public static boolean siEsPrimo (int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean noEsPrimo (int num) {
        return !siEsPrimo(num);
    }

    public static int cifras (int num){
        // En el caso de que sea negativo lo volvemos positivo
        if (num < 0) {
            num = -num;
        }

        // Si el número es 0, tiene un dígito
        if (num == 0) {
            return 1;
        }

        int contador = 0;

        // Contar los dígitos dividiendo por 10 repetidamente
        while (num > 0) {
            num /= 10;
            contador++;
        }

        return contador;
    }

    public static int pares (int num){
        if (num < 0) {
            num = -num;
        }
        int pares = 0;

        while (num > 0) {
            num /= 10;
            if (num % 2 == 0) pares++;
        }
        return pares;
    }

    public static int impares (int num){
        if (num < 0) {
            num = -num;
        }
        int impares = 0;

        while (num > 0) {
            num /= 10;
            if (num % 2 != 0) impares++;
        }
        return impares;
    }

    public static int factorial (int num){
        for (int i = 1; i <= num; i++) {
            num *= i;
        }
        return num;
    }

    public static int factorialR (int num){

        if (num == 0){
            return 1;
        } else return num * factorialR(num - 1);
    }

    public static int ecuacion (int a, int b, int c) {

        int d = (b * 2) - (4 * a * c);

        if (d > 0) return 2;
        if (d == 0) return 1;
        return 0;
    }

    public static int sumadigitos (int num){

        if (num < 0) {
            num = -num;
        }

        int suma = 0;
        while (num > 0) {
            int digito = num % 10;
            suma = suma + digito;
            num /= 10;

        }
        return suma;
    }
}