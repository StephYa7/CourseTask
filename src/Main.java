import AnimalClasses.Horses;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Horses hors = new Horses("h1",new Date());
        System.out.println(hors.getCommandsList());
        hors.addCommand("sd");
        System.out.println(hors.getCommandsList());

    }
}