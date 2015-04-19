package model.item;

import model.entity.Entity;
import model.stat.Stats;

public abstract class TakeableItem extends Item {

    private Stats stats;
    private int value;

    public TakeableItem(String name) {
        super(name);
    }

    public void setItemStats(Stats stats) {
        this.stats = stats;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Stats getItemStats() {
        return stats;
    }

    public abstract void touch(Inventory inventory);

    public void drop(Entity entity) {
        //entity.dropItem
    }
}

