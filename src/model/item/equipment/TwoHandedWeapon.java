package model.item.equipment;

import model.item.SmasherEquipmentManager;

public class TwoHandedWeapon extends SmasherEquipment {

    public TwoHandedWeapon(String name, int value) {
        super(name, value);
    }

    @Override
    public boolean doEquip(SmasherEquipmentManager smasherEM) {
        return smasherEM.equipTwoHandedWeapon(this);
    }

    @Override
    public boolean doUnEquip(SmasherEquipmentManager smasherEM) {
        return smasherEM.unequipTwoHandedWeapon();
    }
}