package model.item.oneShotItemAbility;

import model.entity.Entity;

public class WaterWalkAbility implements Ability {
    private boolean walkAbility;

    public WaterWalkAbility(boolean walkAbility) {
        this.walkAbility = walkAbility;
    }

    @Override
    public void perform(Entity e) {
        e.setCanMoveOnWater(walkAbility);
    }
}
