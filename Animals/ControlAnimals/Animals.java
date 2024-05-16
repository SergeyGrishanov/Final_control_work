package ControlAnimals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Animals {
    private final int id;
    private static int counter = 0;

    private  String name;
    private  final String birthday;
    private double weight;
    private final  int type;

    protected final ArrayList<String> command_animal;

  
    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public double getWeight() {
        return weight;
    }

    public int getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public Animals(String name, String birthday, double weight, int type) {
        this.name = name;
        this.birthday = birthday;
        this.weight = weight;
        this.type = type;
        this.command_animal = new ArrayList<>(Arrays.asList("Run!", "Up!", "Down!", "Voice!"));

        this.id = ++counter;
    }
    
    public int getId(){ return this.id; }

    public String toString(){
        return  String.format(
                Locale.getDefault(),
                """
                        Имя животного: %s\s
                        Возраст животного: %s\s
                        Вес животного: %.2f кг \s
                        Тип (род) животного: %s\s (1 - Кошка, 2 - Собака, 3 - Хомяк, 4 - Лошадь, 5 - Верблюд, 6 - Осёл)
                        """,
                this.name,this.birthday, this.weight, this.type);}

    public ArrayList<String> getCommand_animal() {

        return command_animal;
    }

    public void add_command_animal(String command){
        command_animal.add(command);
    }

    
}
