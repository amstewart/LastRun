package model.item;

import model.entity.Entity;
import model.entity.avatar.Avatar;
import model.entity.avatar.occupation.Occupation;
import model.item.ability.ItemAbility;
import model.stat.Stats;

public abstract class OneShotItem extends Item {

    private ItemAbility ability;

    public OneShotItem(String name, int value) {
        super(name, value);
    }

    protected void setAbility(ItemAbility ability) {
        this.ability = ability;
    }

    protected ItemAbility getAbility() { return ability; }
}
