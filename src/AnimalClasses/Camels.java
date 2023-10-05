package AnimalClasses;

import java.util.Date;

public class Camels extends PackAnimals{
    public Camels(String name, Date birthDate) {
        super(name, birthDate);
        addCommand("grunting");
    }
}