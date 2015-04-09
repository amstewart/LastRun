package model.item.equipment;

import model.item.SneakEquipmentManager;

public class Range extends SneakEquipment {

    public Range(String name, int value) {
        super(name, value);
    }

    @Override
    public boolean doEquip(SneakEquipmentManager sneakEM) {
        return sneakEM.equipRange(this);
    }

    @Override
    public boolean doUnEquip(SneakEquipmentManager sneakEM) {
        return sneakEM.unequipRange();
    }


}
