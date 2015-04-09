package model.item.equipment;

import model.item.EquipmentManager;

public class Chest extends BasicEquipment{
    public Chest(String name, int value) {
        super(name, value);
    }

    @Override
    public boolean doEquip(EquipmentManager em) {
        return em.equipChest(this);
    }

    @Override
    public boolean doUnequip(EquipmentManager em) {
        return em.unequipChest();
    }

}
