package AnimalClasses;

import java.util.Date;

public class Camels extends PackAnimals {
    private static String animalClass = "Верблюд";

    public Camels(String name, Date birthDate) {
        super(name, birthDate);
        addCommand("grunting");
    }

    public static String getAnimalClass() {
        return animalClass;
    }

    @Override
    public String toString() {
        return animalClass + super.toString();
    }
}