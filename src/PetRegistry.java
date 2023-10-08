import AnimalClasses.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PetRegistry {
    private List<ParentСlass> animals;

    public PetRegistry() {
        this.animals = new ArrayList<>();
    }

    public List<ParentСlass> getAnimalsList() {
        return animals;
    }

    public void setAnimalsList(List<ParentСlass> animals) {
        this.animals = animals;
    }

    public void addAnimal(int menuNumber, String name, Date date) {
        try {
            ParentСlass animal = null;
            Count count = new Count();
            count.add();
            if (name != null && date != null) {
                count.close();
            }
            switch (menuNumber) {
                case 1 -> animal = new Cats(name, date);
                case 2 -> animal = new Dogs(name, date);
                case 3 -> animal = new Hamsters(name, date);
                case 4 -> animal = new Horses(name, date);
                case 5 -> animal = new Camels(name, date);
                case 6 -> animal = new Donkeys(name, date);
                default -> System.out.println("Вы ввели не существующий вариант");
            }
            this.animals.add(animal);
            if (!count.isResourceClosed()) {
                throw new MyException();
            }
        } catch (MyException e) {
            System.out.println("name или data == null");
        }
    }

    public ParentСlass getAnimal(int index) {
        return this.animals.get(index);
    }


}