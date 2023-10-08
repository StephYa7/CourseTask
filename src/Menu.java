import AnimalClasses.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    public PetRegistry petRegistry = new PetRegistry();

    public void mainMenu() {
        petRegistry.addAnimal(1,null, new Date(566266));
        petRegistry.addAnimal(2,"собака", new Date(5666336));
        petRegistry.addAnimal(3,"осел", new Date(56666));
        petRegistry.addAnimal(4,"конь", new Date(5663266));
        petRegistry.addAnimal(5,"хомяк", new Date(5663366));
        petRegistry.addAnimal(6,"верблюд", new Date(56344666));
        Scanner scanner = new Scanner(System.in);
        int menuNumber = 1;
        while (menuNumber != 0) {
            System.out.println("Введите номер операции: 1.Добавить животное. 2.Меню добавленных животных. 0.Выход.");
            menuNumber = scanner.nextInt();
            if (menuNumber == 1) {
                animalCreationMenu();
            } else if (menuNumber == 2) {
                menuOfCreatedAnimals();
            } else if (menuNumber == 0) {
                System.out.println("До свидания.");
                return;
            } else {
                System.out.println("Вы ввели неверный номер.");
            }
        }
    }

    public void animalCreationMenu() { // разделить на функции и разобраться с выводом дат
        int menuNumber;
        String name;
        String dateString;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер животное которое хотите добавить: 1.Кошка. 2.Собака. 3.Хомяк. 4.Лошадь. 5.Верблюд. 6.Осел. 0.Выход");
        menuNumber = scanner.nextInt();
        if (menuNumber == 0) {
            return;
        }
        System.out.println("Введите имя животного.");
        name = scanner.next();
        System.out.println("Введите дату рождения в формате дд.мм.гггг .");
        dateString = scanner.next();


        ParentСlass animal = null;
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.mm.yyyy");
        Date date = null;
        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Вы не правильно ввели дату.");
            return;
        }

        petRegistry.addAnimal(menuNumber,name,date);

    }

    public void menuOfCreatedAnimals() { // переделать через for?
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        for (ParentСlass animal : petRegistry.getAnimalsList()) {
            System.out.println(i++ + ". " + animal);
        }


        int menuNumber = 1;
        while (menuNumber != 0) {
            System.out.println("1. Посмотреть команды животного. 2. Добавить команды животному. 0. Выход.");
            menuNumber = scanner.nextInt();
            if (menuNumber == 1) menuShowCommandAnimal();
            else if (menuNumber == 2) menuAddCommandAnimal();
            else if (menuNumber == 0) return;
            else {
                System.out.println("Вы ввели несуществующий номер.");
                menuOfCreatedAnimals();
            }

        }


    }

    public void menuShowCommandAnimal() {
        int numberAnimal;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер животного.");
        numberAnimal = scanner.nextInt();

        try {
            System.out.println(petRegistry.getAnimal(numberAnimal).getCommandsList());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вы ввели номер не существующего животного.");
        }

    }

    public void menuAddCommandAnimal() {
        int numberAnimal;
        String newCommandName;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер животного которому хотите добавить команду.");
        numberAnimal = scanner.nextInt();
        System.out.println("Введите команду для добавления.");
        newCommandName = scanner.next();

        try {
            petRegistry.getAnimal(numberAnimal).addCommand(newCommandName);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вы ввели номер не существующего животного.");
        }


    }
}