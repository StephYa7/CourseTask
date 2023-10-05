package AnimalClasses;

import java.util.Date;

public abstract class Pets extends ParentСlass {
    public Pets(String name, Date birthDate) {
        super(name, birthDate);
        addCommand("having fun");
    }

}