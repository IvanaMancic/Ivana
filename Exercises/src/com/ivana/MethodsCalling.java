package com.ivana;

import java.util.Scanner;

public class MethodsCalling {

    public static void isNumberPositive(int number) {
        if (number > 0) {
            System.out.println("Number " + number + " is positive");
        }
        else if (number < 0) {
            System.out.println("Number " + number + "is negative");
        }
        else {
            System.out.println("Number is 0");
        }
    }

    public static void swapFunction (int a, int b){
        int c = a;
        a = b;
        b = c;
        System.out.println (a +" "+ b);
    }

    public static boolean isNumberPositiveB (int a) {
        boolean b;
        if (a>0) {
            b=true;
        }
        else if (a<0) {
            b=false;
        }
        else {b=false;
        }
        return b;
    }

    public static double areaSquare (double h, double v) {
        double area = h * v;
        return area;
    }




    public static void main(String[] args) {
//    // metoda 1
//       Scanner scan1 = new Scanner (System.in);
//        System.out.println("Enter the number:");
//         int checkNumber = scan1.nextInt();
//        isNumberPositive(checkNumber);
//
//    //metoda 2
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter first number:");
//        int x = scan.nextInt();
//        System.out.println("Enter second number:");
//        int y = scan.nextInt();
//        System.out.println(x+" "+ y);
//
//        swapFunction (x, y);
//        //metoda stampa sa obrutim vrednostima, ali se vrednosti ne dodeljuju varijablama x i y
//
//        System.out.println(x+" "+ y);
//        //x i y imaju vrednosti unete na pocetku

//        //metoda 3
//        Scanner scan2 = new Scanner (System.in);
//        System.out.println("Enter the number:");
//        int checkNumber = scan2.nextInt();
//        isNumberPositiveB(checkNumber);
//        boolean b = isNumberPositiveB (checkNumber);
//        System.out.println(b);


        //metoda 4
        Scanner scan3 = new Scanner (System.in);
        System.out.println("Enter number");
        double v = scan3.nextDouble();
        System.out.println("Enter number");
        double h = scan3.nextDouble();
        areaSquare(v,h);
        System.out.println("The area of the square is: " + areaSquare(v, h));




    }






}