package model.item;

import model.tile.Tile;
import model.bank.BankAccount;
import model.entity.Avatar;
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

   public boolean equip(Avatar avatar) {
        return avatar.equip(this, slotCategory);
        // stats.mergeStats(getItemStats());
    }

    public boolean unequip(Avatar avatar) {
        return avatar.unequip(this, slotCategory);
        // stats.unMergeStats(getItemStats());
    }

	@Override
	public void accept(Entity e, Tile t) {
		t.removeItem(this);
		e.visit(this);
	}

	@Override
	public void sell(BankAccount bankAccount, Inventory inventory) {
		// TODO Auto-generated method stub
		
	}

}
