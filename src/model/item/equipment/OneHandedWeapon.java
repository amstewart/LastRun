package model.item.equipment;

import model.item.SmasherEquipmentManager;

public class OneHandedWeapon extends SmasherEquipment {

    public OneHandedWeapon(String name, int value) {
        super(name, value);
    }
    
    public OneHandedWeapon() {
        super("Sword", 50);
    }

    @Override
    public boolean doEquip(SmasherEquipmentManager smasherEM) {
        return smasherEM.equipOneHandedWeapon(this);
    }

    @Override
    public boolean doUnEquip(SmasherEquipmentManager smasherEM) {
        return smasherEM.unequipOneHandedWeapon();
    }
}
