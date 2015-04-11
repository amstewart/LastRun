package model.item.equipment;

import model.entity.Occupation;
import model.item.SmasherEquipmentManager;

public abstract class SmasherEquipment extends Equipment {

    public SmasherEquipment(String name, int value) {
        super(name, value);
    }

    public abstract boolean doEquip(SmasherEquipmentManager smasherEM );

    public abstract boolean doUnEquip(SmasherEquipmentManager smasherEM);

    @Override
    public boolean use(Occupation occupation) {
        return occupation.addToEquipment(this);
    }
}