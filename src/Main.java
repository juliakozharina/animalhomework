import animals.Animal;
import animals.data.AnimalTypeData;
import animals.data.CommandsData;
import animals.factory.AnimalFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();


        while (true) {
            System.out.println("Введите одну из команд add/list/exit");
            String commandsStr = scanner.next().trim().toUpperCase(Locale.ROOT);
            boolean isExist = false;
            for (CommandsData commandsData : CommandsData.values()) {
                if (commandsData.name().equals(commandsStr)) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                System.out.println(String.format("Команда %s не поддерживается", commandsStr));
                continue;
            }
            CommandsData commandsData = CommandsData.valueOf(commandsStr);
            switch (commandsData) {
                case ADD: {
                    System.out.println("Введите одно из животных cat/dog/duck");


                    AnimalFactory animalFactory = new AnimalFactory();

                    String animalStr = scanner.next().trim().toUpperCase(Locale.ROOT);
                    Animal animal = animalFactory.create(animalStr);

                    while (animal == null) {
                        System.out.println("Вы ввели неверный тип животного");
                        animalStr = scanner.next().trim().toUpperCase(Locale.ROOT);
                        animal = animalFactory.create(animalStr);
                    }

                    animals.add(fillAnimalData(animal));
                    break;

                }
                case LIST: {
                    for (Animal animal : animals) {
                        System.out.println(animal.toString());
                    }
                    break;
                }
                case EXIT: {
                    System.exit(0);
                }
            }
        }
    }

    private static Animal fillAnimalData(Animal animal) {
        System.out.println("Введите имя животного");
        animal.setName(scanner.next());

        System.out.println("Введите возраст животного");
        animal.setAge(parseAge(scanner.next()));

        System.out.println("Введите вес животного");
        animal.setWeight(Integer.parseInt(scanner.next()));

        System.out.println("Введите цвет животного");
        animal.setColor(scanner.next());

        return animal;
    }

    private static int parseAge(String inputAge) {
        while (true) {
            if (checkAge(inputAge)) {
                return Integer.parseInt(inputAge);
            } else {
                System.out.println("Введено некорректное число, число должно быть от 1 до 100.");
                System.out.println("Пожалуйста, попробуйте еще раз.");
            }
        }
    }

    private static boolean checkAge(String inputAge) {
        try {
            int age = Integer.parseInt(inputAge);
            return age > 0 && age <= 100;

        } catch (NumberFormatException e) {
            return false;
        }
    }

}

