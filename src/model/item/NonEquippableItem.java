package model.item;

import model.stat.Stats;

// Nonequippable Items are items that can only be used... like One shot Item
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
}
