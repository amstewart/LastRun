package model.item;

import model.entity.Avatar;
import model.entity.Occupation;

public class OneShotItem extends Item {

    public OneShotItem(String name, int value) {
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
