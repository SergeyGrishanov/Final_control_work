package Model;

import java.util.Collection;

import ControlAnimals.Animals;

public interface View {
    void showAnimals(Collection<Animals> var1);
    void setObserver(ViewObserver var1);
}
