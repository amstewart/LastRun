package model.item;


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

    public void use(Stats stats) {
        System.out.println("You just used " + this.getName());
        stats.mergeStats(getItemStats());
    }

	@Override
	public void accept(Entity e, Tile t) {
		t.removeItem(this);
		e.visit(this);
	}
}
