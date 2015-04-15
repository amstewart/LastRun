package model.item.equipment;

import model.entity.occupation.Occupation;
import model.item.SneakEquipmentManager;

public abstract class SneakEquipment extends Equipment {

    public SneakEquipment(String name, int value) {
        super(name, value);
    }

    public abstract boolean doEquip(SneakEquipmentManager sneakEM);

    public abstract boolean doUnEquip(SneakEquipmentManager sneakEM);

    @Override
    public boolean use(Occupation occupation) {
        return occupation.addToEquipment(this);
    }

    @Override
    public boolean unUse(Occupation occupation) {
        return occupation.removeFromEquipment(this);
    }

}
