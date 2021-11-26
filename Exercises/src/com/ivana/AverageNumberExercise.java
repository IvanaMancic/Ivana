package com.ivana;

import java.util.Scanner;

public class AverageNumberExercise {

    public static void main (String []args) {
        double count=1;
        double number = 0;
        double enterNumber;

        Scanner num = new Scanner (System.in);
        System.out.println ("Enter the number ");
        enterNumber = num.nextDouble();
        if (enterNumber != 7654){
        number += enterNumber;

            do {
                System.out.println("Enter the next number");
                enterNumber = num.nextDouble();
                number += enterNumber;
                count++;



            } while ( enterNumber != 7654);
        }
        else {System.out.println ("You decided not to count the average");}

    double avgn = (number/count);
       System.out.println (avgn);



    }
}
