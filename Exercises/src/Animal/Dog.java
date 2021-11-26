package Animal;
import Animal.Animal;

public class Dog extends Animal {

    public enum DogGender {

        Male, Female
    }

    DogGender gender;

    public Dog (String name, boolean bark, AnimalType type, DogGender gender) {
        super (name,bark, type);
//        super.name=name;
//        super.bark=bark;
//        super.type=type;
        this.gender=gender;
    }


}
