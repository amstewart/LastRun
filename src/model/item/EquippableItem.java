package model.item;

import model.bank.BankAccount;
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

	@Override
	public void accept(Entity e, Tile t) {
		t.removeItem(this);
		e.visit(this);
	}

    @Override
    public void sell(BankAccount bankAccount, Inventory inventory) {
        bankAccount.deposit(this.getValue());
        inventory.remove(this);
    }

    public boolean equip(EquipmentHandler equipmentHandler) {
        return equipmentHandler.equip(this, slotCategory);
    }

    public boolean unequip(EquipmentHandler equipmentHandler) {
        return equipmentHandler.unequip(this, slotCategory);
    }
}
