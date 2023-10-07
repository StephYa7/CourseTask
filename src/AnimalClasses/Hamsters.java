package AnimalClasses;

import java.util.Date;

public class Hamsters extends Pets {
    private static String animalClass = "Хомяк";
    public Hamsters(String name, Date birthDate) {
        super(name, birthDate);
        addCommand("squeaking");
    }
    public static String getAnimalClass() {
        return animalClass;
    }
    @Override
    public String toString() {
        return animalClass + super.toString();
    }
}