package Model;

import java.util.ArrayList;

import ControlAnimals.Animals;

public interface Model {


    void get_new_animal(String var1, String var2, double var3, int var4);



    ArrayList<Animals> load_animal();

    void get_command_animal(String var1);

    void learn_command_animal(String var1 , String var2);



}
