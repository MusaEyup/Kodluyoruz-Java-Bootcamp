package entities.airlines;

import entities.abstracts.IPackage;
import entities.abstracts.Plane;

public class THY extends Plane implements IPackage {

    public THY(int capacity, int fare) {
        super(capacity, fare);
    }

    @Override
    public String extraPackage() {
        return "THY yolculari extra Bagaj hakkına sahiptir";
    }
}
