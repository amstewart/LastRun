package model.item;

import model.entity.Entity;
import model.item.ability.HealAbility;

public class HealItem extends OneShotItem {

    public HealItem(String name, int value, int amount) {
        super(name, value);
        setAbility(new HealAbility(amount));
    }

    @Override
    public boolean touch(Entity entity) {
        getAbility().perform(entity);
        return true;
    }
}
