package model.item.equipment;

import model.item.EquipmentManager;

public class Legs extends BasicEquipment {
    public Legs(String name, int value) {
        super(name, value);
    }

    @Override
    public boolean doEquip(EquipmentManager em) {
        return em.equipLegs(this);
    }

    @Override
    public boolean doUnequip(EquipmentManager em) {
        return em.unequipLegs();
    }
}
