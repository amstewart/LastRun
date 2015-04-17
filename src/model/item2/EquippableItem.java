package model.item2;

import java.util.ArrayList;

public class EquippableItem extends TakeableItem {

    private String slotCategory;

    public EquippableItem(String name,String slot) {
        super(name);
        slotCategory = slot;
    }

    public void equip(EquipmentHandler equipmentHandler ) {
        equipmentHandler.equip(this, slotCategory);
    }

    public void unequip(EquipmentHandler equipmentHandler) {
        equipmentHandler.equip(this, slotCategory);
    }

}
