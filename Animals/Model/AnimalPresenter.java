package Model;

import java.util.ArrayList;
import java.util.Collection;

import ControlAnimals.Animals;

public class AnimalPresenter implements ViewObserver {
    private final Model animalServserse;

    private final View animalviewer;

    public AnimalPresenter(Model animalServserse, View animalviewer ){
        this.animalServserse = animalServserse;
        this.animalviewer = animalviewer;
        animalviewer.setObserver(this);

    }

    public Collection<Animals> loadAnimals(){return this.animalServserse.load_animal();}

    public void loadReservationAnimalResult(ArrayList<Animals> getanimalresult ){
        this.animalviewer.showAnimals(getanimalresult);
    }



    public void onGetAnimal(String name, String birthday, double weight, int type) {
        this.animalServserse.get_new_animal(name,birthday,weight,type);

    }



    @Override
    public void loadAnimalRegister() {
        this.loadReservationAnimalResult(this.animalServserse.load_animal());
    }
}
