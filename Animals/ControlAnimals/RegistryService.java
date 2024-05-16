package ControlAnimals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


import Model.Model;

public class RegistryService implements Model {
    private final ArrayList<Animals> animalRegists;
    public RegistryService() {
        this.animalRegists = new ArrayList<>();
    }

    public void get_new_animal(String name, String birthday, double weight, int type) {

            Counter count = new Counter();
            HashMap<Integer,Animals> check = new HashMap<>();
            check.put(1,new Cats(name,birthday,weight,type));
            check.put(2,new Dogs(name,birthday,weight,type));
            check.put(3,new Hamstels(name,birthday,weight,type));
            check.put(4,new Hourses(name,birthday,weight,type));
            check.put(5,new Camels(name,birthday,weight,type));
            check.put(6,new Donkeys(name,birthday,weight,type));

            Animals animals = check.get(type);
            animalRegists.add(animals);
            assert animals != null;
            count.add_count();

    }

    public ArrayList<Animals> load_animal() {

        return animalRegists;
    }

    @Override
    public void get_command_animal(String name) {
        for (Animals animals : this.animalRegists){
            if(Objects.equals(name, animals.getName())){
                System.out.println(animals.getCommand_animal());
            }
        }
    }

    @Override
    public void learn_command_animal(String name, String command) {
        for (Animals animals : this.animalRegists){
            if(Objects.equals(name, animals.getName())){
                animals.add_command_animal(command);
                System.out.println("Skill Learn");
            }
        }
    }
}
