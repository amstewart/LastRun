package model.item.oneShotItemAbility;

import model.entity.Entity;

public class StrengthBoostAbility implements Ability {

    private int strengthBoost;

    public StrengthBoostAbility(int strengthBoost) {
        this.strengthBoost = strengthBoost;
    }

    @Override
    public void perform(Entity e) {
        e.setStrength(strengthBoost);
    }
}
