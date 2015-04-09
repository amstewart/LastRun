package model.item.equipment;

import model.item.EquipmentManager;

public class Head extends BasicEquipment {
    public Head(String name, int value) {
        super(name, value);
    }

    @Override
    public boolean doEquip(EquipmentManager em) {
        return em.equipHead(this);
    }

    @Override
    public boolean doUnequip(EquipmentManager em) {
        return em.unequipHead();
    }
}
