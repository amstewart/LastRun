package model.item;

import model.item.ability.ItemAbility;

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
