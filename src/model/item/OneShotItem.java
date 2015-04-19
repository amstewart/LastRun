package model.item;

import model.entity.Entity;
import model.item.oneShotItemAbility.Ability;
import model.tile.Tile;

//One shot applies their effect to the entity on touch and is removed from the map
public class OneShotItem extends Item {

    private Ability ability;

    public OneShotItem(String name) {
        super(name);
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    @Override
    public void accept(Entity e, Tile tile) {
        ability.perform(e);
        tile.removeItem(this);
    }
}
