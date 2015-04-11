package model.item;

import model.entity.Entity;
import model.item.ability.DamageAbility;

public class DamageItem extends OneShotItem {

    public DamageItem(String name, int value, int amount) {
        super(name, value);
        setAbility(new DamageAbility(amount));
    }

    @Override
    public boolean touch(Entity entity) {
        return false;
    }
}
