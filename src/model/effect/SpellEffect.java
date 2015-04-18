package model.effect;

import model.entity.Entity;
import model.map.GameMap;
import model.map.LocalArea;

public interface SpellEffect extends Effect{
	public void applyMultiplier(int m);
	public void applyEffect(GameMap map, Entity entity, int radius);
	public void setCanPerform(int mana);
}
