package model.item.ability;

import model.entity.Entity;

public abstract class ItemAbility {
    private int amount;

    public ItemAbility(int amount) {
        this.amount = amount;
    }

    protected int getAmount() {
        return amount;
    }

    public abstract void perform(Entity entity);
}
