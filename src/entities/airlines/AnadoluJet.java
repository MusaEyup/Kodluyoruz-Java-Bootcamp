package entities.airlines;

import entities.abstracts.IAbroad;
import entities.abstracts.Plane;

public class AnadoluJet extends Plane implements IAbroad {



    public AnadoluJet(int capacity, int fare) {
        super(capacity, fare);

    }

    @Override
    public String foodChoice() {
        return "Yurtdışı uçuşu olduğu için uçağımızda yemek seçme hakkına sahipsiniz";
    }


}
