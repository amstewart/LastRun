package model.item;

import model.entity.avatar.Avatar;
import model.entity.avatar.occupation.Occupation;

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
