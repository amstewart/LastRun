package model.item2;

import java.util.ArrayList;

public class EquippableItem extends TakeableItem {

    private ArrayList<String> slotCategories;

    public EquippableItem() {
        slotCategories = new ArrayList<String>();
    }

    public EquippableItem(String slotCategory){
        this();
        slotCategories.add(slotCategory);
    }

    public EquippableItem(ArrayList<String> slotCategories){
        this();
        this.slotCategories = slotCategories;
    }

    public void equip(EquipmentHandler equipmentHandler ) {
        equipmentHandler.equip(this, slotCategories);
    }

    public void unequip(EquipmentHandler equipmentHandler) {
        equipmentHandler.equip(this, slotCategories);
    }

}
