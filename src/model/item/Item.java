package model.item;

import model.entity.Entity;
import model.entity.avatar.Avatar;
import model.entity.avatar.occupation.Occupation;

public abstract class Item {
    private String name;
    private int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public abstract boolean touch(Entity entity);

}
