package model.effect;

import model.entity.Entity;
import model.map.GameMap;
import model.map.LocalArea;
import model.movement.EntityMovement;

public interface SpellEffect extends Effect{
	public void applyMultiplier(int m);
	void applyEffect(GameMap map, Entity entity, EntityMovement emov, int radius);
	public void setCanPerform(int mana);
}
