package AnimalClasses;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class ParentСlass {
    private static String animalClass;
    private List<String> commands = new ArrayList<>();
    private String name;
    private Date birthDate;

    //<editor-fold desc="Constructor + getters + setters>
    public ParentСlass(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        addCommand("eating");
        addCommand("sleeping");
        System.out.println("Вы успешно добавили животное в список.");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getCommandsList() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    //</editor-fold> =+
    public String getCommand(int index) {
        return commands.get(index);
    }

    public void addCommand(String command) {
        this.commands.add(command);
    }


    public void commandExecution(int commandNumber) {
        System.out.println(getName() + getCommand(commandNumber));
    }
    @Override
    public String toString() {
        return  " с именем: " + getName() +
                ", дата рождения:" + getBirthDate() + " ";
    }
}