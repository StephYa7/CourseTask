package AnimalClasses;

import java.util.Date;

public class Dogs extends Pets{
    private static String animalClass = "Собака";
    public Dogs(String name, Date birthDate) {
        super(name, birthDate);
        addCommand("barking");
    }
    public static String getAnimalClass() {
        return animalClass;
    }
    @Override
    public String toString() {
        return animalClass + super.toString();
    }
}