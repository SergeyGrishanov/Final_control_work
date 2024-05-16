package Human_friends;

import java.util.Scanner;

public class Animals {

    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Реест домашних животных");
        //AnimalRegistryService animalRegistryService = new AnimalRegistryService();
        //AnimalNurseryView animalNurseryView = new AnimalNurseryView();
        //new AnimalPresenter(animalRegistryService,animalNurseryView);
        boolean obs = true;
        while (obs){
            System.out.println("""
                    Меню:
                    1 - Домашние животные
                    2 - Вьючные животные
                    3 - Выйти
                    """);
            System.out.println("Выберите раздел: ");
            String choice = console.nextLine();
            int name_animal;
            //String birthday = null;
            //double weight = 0;
            //String type_animal = null;
            //String new_skill = null;
            switch (choice){
                case "1" -> {
                    System.out.println("""
                        Меню:
                        1 - Собаки
                        2 - Кошки
                        3 - Хомяки
                        4 - Морские свинки
                        5 - Выйти
                        """);
                    name_animal = console.nextInt();
                    try {
                        System.out.println("Домашние животные");
                        if(name_animal == 1){
                            
                            System.out.println("""
                                Количество собак - 1,
                                Кличка: Жуля, Дата рождения: '2022-05-05', Цвет: Черная с белым, Знает команды: 'сидеть, лежать, дай лапу'.
                                """);
                                obs = false;   
                        }
                        
                        else if(name_animal == 2){
                            
                            System.out.println("""
                                Количество кошек - 2,
                                Кличка: Туся, Дата рождения:'2022-11-23', Знает команды: 'дай лапу', Цвет: Трехмастная.
                                Кличка: Рыжик, Дата рождения:'2017-11-03', Знает команды: "Прыгает через кольцо", Цвет: Рыжий.
                                """);
                                obs = false;
                        }
                        
                        else if(name_animal == 3){
                            
                            System.out.println("""
                                Количество хомяков - 3,
                                Кличка: Жужу, Дата рождения:'2023-11-08', Знает команды: 'Смешно лежит', Цвет: Коричневый.
                                Кличка: Хома, Дата рождения:'2023-11-08', Знает команды: 'Протягивает лапку за кормом', Цвет: Рыжий.
                                Кличка: Мося, Дата рождения:'2023-07-05', Знает команды: 'Лежать', Цвет: Белый.
                                """);
                                obs = false;         
                        }
                        
                        else if(name_animal == 4){
                            
                            System.out.println("""
                                Количество морских свинок - 2,
                                Кличка: Пушистик, Дата рождения:'2023-04-04', Знает команды: 'Быть пушистым', Цвет: Трехцветный.
                                Кличка: Беляш, Дата рождения:'2023-04-04', Знает команды: 'ничего', Цвет: Черный.
                                """);
                                obs = false;    
                        }
                        
                        else {
                            System.out.println("Вы ввели не коректные данные повторите ввод");
                            
                        }
                        
                    }
                    catch (Exception e){
                        System.out.println("Данные введеные не верно");
                    }
                    
                    
                    
                    
                }
                case "2" -> {
                    System.out.println("""
                        Меню:
                        1 - Верблюды
                        2 - Лошади
                        3 - Ослики
                        4 - Выйти
                        """);
                    name_animal = console.nextInt();
                    try {
                        System.out.println("Вьючные животные");
                        if(name_animal == 1){
                            
                            System.out.println("""
                                Количество верблюдов - 1,
                                Кличка: Лосяш, Дата рождения:'2019-04-20', Грузоподъемность: 150 кг, Цвет: Белый.
                                """);
                            obs = false;
                        }
                        if(name_animal == 2){
                            
                            System.out.println("""
                                Количество лошадей - 3,
                                Кличка: Гавриш, Дата рождения:'2019-04-20', Грузоподъемность: 90 кг, Цвет: Черный в яблоко.
                                Кличка: Галя, Дата рождения:'2020-03-14', Грузоподъемность: 70 кг, Цвет: Коричневый.
                                Кличка: Томсон, Дата рождения:'2020-05-25', Грузоподъемность: 80 кг, Цвет: Коричневый.
                                """);
                            obs = false;
                        }
                        if(name_animal == 3){
                            
                            System.out.println("""
                                Количество осликов - 4,
                                Кличка: Джек, Дата рождения:'2022-09-18', Грузоподъемность: 70 кг, Цвет: Серый.
                                Кличка: Джон, Дата рождения:'2022-08-17', Грузоподъемность: 75 кг, Цвет: Серый.
                                Кличка: Анжелина, Дата рождения:'2021-04-30', Грузоподъемность: 60 кг, Цвет: Черный.
                                Кличка: Муся, Дата рождения:'2022-03-31', Грузоподъемность: 55 кг, Цвет: Серый.
                                """);    
                            obs = false;
                        }
                        else {
                            System.out.println("Вы ввели не коректные данные повторите ввод");
                        }


                    }
                    catch (Exception e){
                        System.out.println("Данные введеные не верно");
                    }
                    
                }
                case "3" -> {
                    String by = "До свидания";
                    System.out.println("\n" + by.toUpperCase());
                    obs = false;
                }



            }

        }
    }

}