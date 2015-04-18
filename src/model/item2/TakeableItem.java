package model.item2;

import model.entity.Entity;

public class TakeableItem extends Item {

    public TakeableItem(String name) {
        super(name);
    }
    public void touch(Entity entity) {
        //entity.addToInventory(this);
    }

    public void drop(Entity entity) {
        //entity.dropItem
    }
}

