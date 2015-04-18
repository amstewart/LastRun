package model.item;


import model.bank.BankAccount;
import model.entity.Entity;
import model.stat.Stats;
import model.tile.Tile;

public class NonEquippableItem extends TakeableItem {

    public NonEquippableItem(String name) {
        super(name);
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

    public void use(Stats stats) {
        System.out.println("You just used " + this.getName());
        stats.mergeStats(getItemStats());
    }
}
