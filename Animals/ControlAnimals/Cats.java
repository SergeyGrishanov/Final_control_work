package ControlAnimals;

import java.util.ArrayList;

public class Cats extends Pets{


    public Cats(String name, String birthday, double weight, int type) {
        super(name, birthday, weight, type);
    }


    @Override
    public ArrayList<String> getCommand_animal() {
        command_animal.add("Climb");
        return command_animal;
    }

}
