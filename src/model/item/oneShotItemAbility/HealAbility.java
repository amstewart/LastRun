package model.item.oneShotItemAbility;

import model.entity.Entity;

public class HealAbility implements Ability {

    private final int livesBoost;

    public HealAbility(int livesBoost) {
        this.livesBoost = livesBoost;
    }

    @Override
    public void perform(Entity e) {
        e.setLivesLeft(livesBoost);
    }
}
