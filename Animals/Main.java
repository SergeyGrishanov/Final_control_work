import java.util.Scanner;

import ControlAnimals.RegistryService;
import Model.AnimalPresenter;
import View.AnimalView;

public class Main {
    

    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Реест домашних животных");
        RegistryService animalRegistryService = new RegistryService();
        AnimalView animalNurseryView = new AnimalView();
        new AnimalPresenter(animalRegistryService,animalNurseryView);
        boolean obs = true;
        while (obs){
            System.out.println("""
                     Меню:
                    1 - Завести новое животное
                    2 - Увидеть список команд, которое выполняет животное
                    3 - Обучить животное новым командам
                    4 - Вывести всеx животных питомника
                    5 - Выйти
                    """);
            System.out.println("Ваш выбор: ");
            String choice = console.nextLine();
            String name_animal = null;
            String birthday = null;
            double weight = 0;
            int type_animal = 0;
            String new_skill = null;
            switch (choice){
                case "1" -> {
                    System.out.println("Для этого вам необоходимо ввести: " +
                            "имя животного дату его рождения, " +
                            "вес животного в также а также род животного. ");
                    System.out.println("Введите имя животного: ");
                    name_animal = console.nextLine();
                    try {
                        System.out.println("Введите дату рождения животного в формате (2022-01-10): ");
                        if(console.nextLine().length() == 10){
                            birthday = console.nextLine();
                            System.out.println("Введите вес животного: ");
                            weight = Double.parseDouble(console.nextLine());
                            System.out.println("Введите род животного (1 - Кошка, 2 - Собака, 3 - Хомяк, 4 - Лошадь, 5 - Верблюд, 6 - Осёл): ");
                            type_animal = console.nextInt();
                        }
                        else {
                            System.out.println("Вы ввели не коректные данные повторите ввод");
                        }


                    }
                    catch (Exception e){
                        System.out.println("Данные введеные не верно");
                    }
                    finally {
                        System.out.println("Повторите ввод");
                    }


                    animalNurseryView.getanimla(name_animal,birthday,weight,type_animal);


                }
                case "2" -> {
                    System.out.println("Введите имя животного, чьи способности Вас интересуют");
                    name_animal = console.nextLine();
                    try {
                        animalRegistryService.get_command_animal(name_animal);
                    }
                    finally {
                        System.out.println("К сожалению в нашем питомнике нет такого животного");
                    }


                }
                case "3" -> {
                    System.out.println("Введите имя животного кого хотите обучить");
                    name_animal = console.nextLine();
                    System.out.println("Введите команду, которой нужну обучить животное");
                    new_skill = console.nextLine();
                    try {
                        animalRegistryService.learn_command_animal(name_animal,new_skill);
                    }
                    finally {
                        System.out.println("К сожалению в нашем питомнике нет такого животного");
                    }

                }
                case "4" -> {
                        animalNurseryView.loadAnimals();
                }
                case "5" -> {
                    String by = "До свидания!";
                    System.out.println("\n" + by.toUpperCase());
                    obs = false;
                }



            }

        }

    }
}
