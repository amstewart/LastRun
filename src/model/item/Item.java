package model.item;

import model.entity.Avatar;
import model.entity.occupation.Occupation;

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

    public abstract boolean touch(Avatar avatar);

    public abstract boolean use(Occupation occupation);
}
