package AnimalClasses;

import java.util.Date;

public class Donkeys extends PackAnimals {
    public Donkeys(String name, Date birthDate) {
        super(name, birthDate);
        addCommand("braying");
    }
}