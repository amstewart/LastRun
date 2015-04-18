package model.item;

import model.stat.Stats;

public class EquippableItem extends TakeableItem {

    private String slotCategory;

    public EquippableItem(String name,String slot) {
        super(name);
        slotCategory = slot;
    }

    @Override
    public void touch(Inventory inventory) {
        inventory.add(this);
    }

    public void equip(EquipmentHandler equipmentHandler) {
        equipmentHandler.equip(this, slotCategory);
       // stats.mergeStats(getItemStats());
    }

    public void unequip(EquipmentHandler equipmentHandler) {
        equipmentHandler.unequip(this, slotCategory);
       // stats.unMergeStats(getItemStats());
    }

}
