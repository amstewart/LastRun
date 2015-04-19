package model.item.oneShotItemAbility;

import model.entity.Entity;
import view.viewport.DialogueViewport;

public class HealAbility implements Ability {

    private final int livesBoost;

    public HealAbility(int livesBoost) {
        this.livesBoost = livesBoost;
    }

    @Override
    public void perform(Entity e) {
        DialogueViewport.getInstance().print("If ointment works on grandpa, it will on me too");
        e.setLivesLeft(livesBoost);
    }
}
