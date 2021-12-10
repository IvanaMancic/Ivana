package Animal;

import java.util.Scanner;

public class Animal {
    protected String name;
    protected String colour;
    protected String dateOfBirth;
    protected int weight;
    protected boolean bark;
    protected AnimalType type;


    public Animal () {

        }

    public Animal(String name, boolean bark, AnimalType type) {
        this.name = name;
        this.bark = bark;
        this.type = type;
    }

    public Animal(String name, String colour, String dateOfBirth, int weight, boolean bark, AnimalType type) {
        this.name = name;
        this.colour = colour;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.bark = bark;
        this.type = type;
    }
    //Ova dva konstruktora su nepotrebna, radi i samo sa praynim, ali bez praznog - ne

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getWeight() {
        return weight;
    }



    public AnimalType getType() {
        return type;
    }

    public enum YesNo {
        Y, N
    }
//    public static void doesAnimalEatMilk (){
//        System.out.println("If animal eats milk, type Y, if animal doesn't eat milk, type N");
//        Scanner scan = new Scanner (System.in);
//        String question = scan.next();
//        if (question.equals(YesNo.Y)) {
//            System.out.println("This animal eats milk" );
//        else if (question.equals(YesNo.N)){
//            System.out.println("This animal doesn't eat milk");
//            }
//        else {
//            System.out.println("Enter Y or N");
//            }
//        }
//}
////
    public  boolean doesAnimalBarkBark () {
         if (bark) {
            return true;
         }
         else {
                return false;
            }
        }
//

    public boolean doesAnimalBark() {
        if (type == AnimalType.Dog) {
            return true;
        } else {
            return false;
        }
    }
}
