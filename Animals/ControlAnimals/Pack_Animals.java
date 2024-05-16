package ControlAnimals;

import java.util.ArrayList;

public class Pack_Animals extends  Animals{



    public Pack_Animals(String name, String birthday, double weight, int type) {
        super(name, birthday, weight, type);

    }

    @Override
    public ArrayList<String> getCommand_animal() {
        command_animal.add("load_cargo");
        command_animal.add("upload_cargo");
        return command_animal;
    }

    public void load_cargo(){
        System.out.println("Груз загружен");
    }

    public void unload_cargo(){
        System.out.println("Груз разгружен");
    }
}
