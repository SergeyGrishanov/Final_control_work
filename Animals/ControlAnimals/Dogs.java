package ControlAnimals;

import java.util.ArrayList;

public class Dogs extends Pets{


    public Dogs(String name, String birthday, double weight, int type) {
        super(name, birthday, weight, type);
    }

    @Override
    public ArrayList<String> getCommand_animal() {
        command_animal.add("Storage");
        return command_animal;
    }
}
