package model.item;

import model.tile.Tile;


import model.entity.Entity;
import model.tile.Tile;

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

	@Override
	public void accept(Entity e, Tile t) {
		t.removeItem(this);
		e.visit(this);
	}

}
