package model.item;

import model.entity.Avatar;
import model.entity.occupation.Occupation;

public class InteractiveItem extends Item {

    public InteractiveItem(String name, int value) {
        super(name, value);
    }

    @Override
    public boolean use(Occupation occupation) {
        return false;
    }

    @Override
    public boolean touch(Avatar avatar) {
        return false;
    }
}
