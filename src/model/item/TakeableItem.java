package model.item;

import model.entity.Entity;

public abstract class TakeableItem extends Item {

    public TakeableItem(String name) {
        super(name);
    }

    public abstract void touch(Inventory inventory);

    public void drop(Entity entity) {
        //entity.dropItem
    }
}

