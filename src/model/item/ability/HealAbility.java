package model.item.ability;

import model.entity.Entity;

public class HealAbility extends ItemAbility {

    public HealAbility(int amount) {
       super(amount);
    }

    @Override
    public void perform(Entity entity) {
        entity.setLivesLeft(getAmount());
    }
}
