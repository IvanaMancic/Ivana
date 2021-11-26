package com.company;

public class Main {

    public static void main(String[] args) {

        int x = 6;
        if ( isLargerThenFive(x) ) {
            System.out.println("OK");
        }
    }

    public static boolean isLargerThenFive(int x) {
        return x > 5;
    }
}
