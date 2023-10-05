package AnimalClasses;

import java.util.Date;

public class Dogs extends Pets{
    public Dogs(String name, Date birthDate) {
        super(name, birthDate);
        addCommand("barking");
    }
}