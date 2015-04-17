package model.item2;

import java.util.ArrayList;

public class EquippableItem extends TakeableItem {

    private ArrayList<String> slotCategories;

    public EquippableItem(String name, ArrayList<String> slots) {
        super(name);
        slotCategories = slots;
    }

    public void equip(EquipmentHandler equipmentHandler ) {
        equipmentHandler.equip(this, slotCategories);
    }

    public void unequip(EquipmentHandler equipmentHandler) {
        equipmentHandler.equip(this, slotCategories);
    }

}
