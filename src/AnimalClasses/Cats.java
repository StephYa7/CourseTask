package AnimalClasses;

import java.util.Date;

public class Cats extends Pets{
    public Cats(String name, Date birthDate) {
        super(name, birthDate);
        addCommand("meow");
    }
}