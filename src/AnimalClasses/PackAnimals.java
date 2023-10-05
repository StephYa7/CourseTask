package AnimalClasses;

import java.util.Date;

public abstract class PackAnimals extends ParentСlass {

    public PackAnimals(String name, Date birthDate) {
        super(name, birthDate);
        addCommand("working");
    }


}