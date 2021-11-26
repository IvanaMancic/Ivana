package com.object;

import java.util.Date;

public class Person {
    int currentYear = 2021;

    private String name;
    String lastName;
    Date date;
    private int yearOfBirth;
    char gender;
    String place;


public Person (String name, String lastName, int yearOfBirth) {
    this.name = name;
    this.lastName = lastName;
    this.yearOfBirth=yearOfBirth;
}
        public String getName () {
        return name;
    }

        public void setName (String name) {
        this.name=name;
            }
        public int getYearOfBirth () {
            return yearOfBirth;
            }

        public void setYearOfBirth (int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
        }



        public int countYears (){
            int countYears = currentYear - yearOfBirth;
            return countYears;
        }



    public static void main (String[] args) {



        Person ivana = new Person ("ivana", "mancic", 1988);

        System.out.println(ivana.yearOfBirth);

        System.out.println(ivana.countYears());




    }
}
