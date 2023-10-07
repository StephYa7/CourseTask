package AnimalClasses;

import java.util.Date;

public class Donkeys extends PackAnimals {
    private static String animalClass = "Осел";
    public Donkeys(String name, Date birthDate) {
        super(name, birthDate);
        addCommand("braying");
    }
    public static String getAnimalClass() {
        return animalClass;
    }
    @Override
    public String toString() {
        return animalClass + super.toString();
    }
}