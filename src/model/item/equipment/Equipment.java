package model.item.equipment;

import model.entity.avatar.occupation.Occupation;
import model.item.TakeableItem;

public abstract class Equipment extends TakeableItem {

    private int levelRequired;

    public Equipment(String name, int value) {
        super(name, value);
    }

    public void setLevelRequired(int level) {
        levelRequired = level;
    }

    protected int getLevelRequired() {
        return levelRequired;
    }
}
