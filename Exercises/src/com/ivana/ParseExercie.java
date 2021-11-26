package com.ivana;

import java.util.Scanner;

public class ParseExercie {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number ");
        String number = scan.next();
        int intNumber = Integer.parseInt(number);
        for (int i = 1; i < 11; i++) {
            System.out.println(intNumber + "x" + i + "=" + (intNumber * i));
        }

    }


}
