package PetRegistry;

import AnimalClasses.ParentСlass;

import java.util.ArrayList;
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

    public void addAnimal(ParentСlass animal) {
        this.animals.add(animal);
    }

    public ParentСlass getAnimal(int index) {
        return this.animals.get(index);
    }


}