package model.item;

import model.entity.Entity;


public class InteractiveItem extends Item {

    public InteractiveItem(String name, int value) {
        super(name, value);
    }

    @Override
    public boolean touch(Entity entity) {
        return false;
    }
}
