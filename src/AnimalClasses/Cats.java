package AnimalClasses;

import java.util.Date;

public class Cats extends Pets{
    private static String animalClass = "Кошка";
    public Cats(String name, Date birthDate) {
        super(name, birthDate);
        addCommand("meow");
    }
    public static String getAnimalClass() {
        return animalClass;
    }
    @Override
    public String toString() {
        return animalClass + super.toString();
    }
}