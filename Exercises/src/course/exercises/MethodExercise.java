package course.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MethodExercise {

    public static void main (String[] args) {

        String w="ivana";

        System.out.println("U reci " + "'" + w + "'" + " slovo A se nalazi " + countLetterA(w) + " puta");

        System.out.println("Obrnuti redosled slova u reci " + "'" + w + "'" + " je " + returnReverseString(w));

        System.out.println(returnReverseString());
    }

    public static int countLetterA (String word) {
        String[] charsFromString = word.split("");
        String list="";
        int countA=0;
        for (int i = 0; i < word.length(); i++) {
            list = charsFromString[i];
            if (list.equalsIgnoreCase("a")){
                countA++;
            }
        }
        return countA;

    }

        public static String returnReverseString () {

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the word");
            String word = scan.next();
            String [] listOfLetters = word.split("");
            String reverseListOfLetters = "";
                for (int i=word.length()-1; i>-1; i--) {
                    reverseListOfLetters= reverseListOfLetters + listOfLetters[i];
            }
             return reverseListOfLetters;
            }


    public static String returnReverseString (String word) {

       String [] listOfLetters = word.split("");
        String reverseListOfLetters = "";
        for (int i=word.length()-1; i>-1; i--) {
            reverseListOfLetters= reverseListOfLetters + listOfLetters[i];
        }
        return reverseListOfLetters;
    }




        }




