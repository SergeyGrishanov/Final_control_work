package ControlAnimals;

public class Pets  extends Animals{


    public Pets(String name, String birthday, double weight, int type) {
        super(name, birthday, weight, type);
    }


    public void Play(){
        System.out.println("Играть");
    }
}
