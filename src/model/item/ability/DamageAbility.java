package model.item.ability;

import model.entity.Entity;

public class DamageAbility extends ItemAbility {

    public DamageAbility(int amount) {
        super(amount);
    }

    @Override
    public void perform(Entity entity) {
        entity.setLivesLeft(getAmount() * (-1));
    }
}
