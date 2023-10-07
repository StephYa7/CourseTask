package AnimalClasses;

import java.util.Date;

public class Horses extends PackAnimals{
    private static String animalClass = "Лошадь";
    public Horses(String name, Date birthDate) {
        super(name, birthDate);
        addCommand("neighing");
    }
    public static String getAnimalClass() {
        return animalClass;
    }


    @Override
    public String toString() {
        return animalClass + super.toString();
    }
}