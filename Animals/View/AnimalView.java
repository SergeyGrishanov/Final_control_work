package View;

import java.util.Collection;

import ControlAnimals.Animals;
import Model.View;
import Model.ViewObserver;

public class AnimalView implements View {

    private ViewObserver observer;

    public AnimalView(){
    }

    public void showAnimals(Collection<Animals> animals){
        for(Animals animal: animals){
            System.out.println(animal);
        }
    }

    public void setObserver(ViewObserver observer){this.observer = observer;}




    public void getanimla(String name, String birthday, double weight, int type){
        this.observer.onGetAnimal(name,birthday,weight, type);
    }

    public void loadAnimals(){
        this.observer.loadAnimalRegister();
    }

}
