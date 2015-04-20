package model.item.oneShotItemAbility;

import model.entity.Entity;
import view.viewport.DialogueViewport;

public class StrengthBoostAbility implements Ability {

    private int strengthBoost;

    public StrengthBoostAbility(int strengthBoost) {
        this.strengthBoost = strengthBoost;
    }

    @Override
    public void perform(Entity e) {
        DialogueViewport.getInstance().print("Got SWOLE!");
        e.setStrength(strengthBoost);
    }
}
