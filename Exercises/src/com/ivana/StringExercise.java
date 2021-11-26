package com.ivana;

public class StringExercise {


    public static void main (String[] args)
    {

        String person = "ivana mihajlovic:iccky";
        String name;
        String lastname;
        String [] data = person.split (" |:");

        // Stringova metoda koja deli string prema zadatom kriterijumu, ovde je to prazno polje)

         name = data [0];
         lastname = data [1];
         String username=data [2];
        System.out.println(name + " " + lastname + " "+ username);

        int stringlength = person.length();
        // Racuna i ispisuje duzinu stringa (i prazna mesta)
        System.out.println (stringlength);




    }



}
