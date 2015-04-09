package model.item.equipment;

import model.item.SmasherEquipmentManager;

public class Shield extends SmasherEquipment {

    public Shield(String name, int value) {
        super(name, value);
    }

    @Override
    public boolean doEquip(SmasherEquipmentManager smasherEM) {
        return smasherEM.equipShield(this);
    }

    @Override
    public boolean doUnEquip(SmasherEquipmentManager smasherEM) {
        return smasherEM.unequipShield();
    }
}
