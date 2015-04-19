package model.item.oneShotItemAbility;

import model.entity.Entity;
import view.viewport.DialogueViewport;

public class WaterWalkAbility implements Ability {
    private boolean walkAbility;

    public WaterWalkAbility(boolean walkAbility) {
        this.walkAbility = walkAbility;
    }

    @Override
    public void perform(Entity e) {
        DialogueViewport.getInstance().print("Looks like I can walk on water like...");
        e.setCanMoveOnWater(walkAbility);
    }
}
