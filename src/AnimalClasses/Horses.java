package AnimalClasses;

import java.util.Date;

public class Horses extends PackAnimals{
    public Horses(String name, Date birthDate) {
        super(name, birthDate);
        addCommand("neighing");
    }
}