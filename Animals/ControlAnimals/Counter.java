package ControlAnimals;

public class Counter {
    public static int counter = 0;

    public Counter() {
    }

    public void add_count(){
        ++counter;
    }

    public int getCounter() {
        return counter;
    }
}
