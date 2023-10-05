package AnimalClasses;

import java.util.Date;

public class Hamsters extends Pets {
    public Hamsters(String name, Date birthDate) {
        super(name, birthDate);
        addCommand("squeaking");
    }
}