package com.ivana;

import java.util.Scanner;

public class MultiplicationArrayExercise {

    public static void main(String[] args) {
        int number;
        int i;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number ");
        number = scan.nextInt();
        for (i = 1; i < 11; i++) {
            System.out.println(number + "x" + i + "=" + (number * i));
        }

    }



    }

