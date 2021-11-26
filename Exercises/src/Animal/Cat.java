package Animal;

import Animal.Animal;

public class Cat extends Animal {

    protected String typeOfCat;

    public Cat (String name, String colour, String dateOfBirth, int weight, boolean bark, AnimalType type, String typeOfCat){
        super.name=name;
        super.colour=colour;
        super.dateOfBirth=dateOfBirth;
        super.weight=weight;
        super.bark=bark;
        super.type=type;
        this.typeOfCat=typeOfCat;
    }

    public String getTypeOfCat() {
        return typeOfCat;
    }


}


