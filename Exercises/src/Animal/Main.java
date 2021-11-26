package Animal;

import Animal.Cat;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //metoda koja pravi listu od stringova unetih kroz konzolu

    public static ArrayList<String> returnListOfAnimalsFromConsole () {
        ArrayList <String> listOfAnimals=new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of animals");
        int number = scan.nextInt();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter the animal");
            String animal = scan.next();
            listOfAnimals.add(animal);
        }
        return listOfAnimals;
    }

    public static void main (String[] args){


//        System.out.println("Created list of animals is: " + returnListOfAnimalsFromConsole());
//        ArrayList <String> listOfAnimals = returnListOfAnimalsFromConsole();
//        System.out.println("The first animal in the list is: " + listOfAnimals.get(0));
        System.out.println("The first animal in the list is: " + returnListOfAnimalsFromConsole().get(0));



        Cat pepita= new Cat("Pepita", "gray", "15/3/2020", 1, false, AnimalType.Cat, "home cat");

        Dog dzoni=new Dog("Dzoni", true, AnimalType.Dog, Dog.DogGender.Male);

        Rabbit skocko = new Rabbit("Skocko");

        System.out.println("Does Pepita bark? " + pepita.doesAnimalBarkBark());
        System.out.println("Animal " + pepita.name + " is " + pepita.type);
        System.out.println("Does Skocko bark? (U objektu skocko nije definisano polje boolean bark iz klase Animal) " + skocko.doesAnimalBarkBark());
        System.out.println(pepita.getName());
        System.out.println(dzoni.doesAnimalBark());
        System.out.println(dzoni.gender);
        System.out.println(dzoni.name);
    //zasto ne mora get? Zato sto je modifier protected, ne private



    }




    }



