package model.effect;

import model.entity.Entity;
import model.map.LocalArea;

public interface SpellEffect extends Effect{
	public void applyMultiplier(int m);
	public void applyEffect(LocalArea map, Entity entity);
	public void setCanPerform(int mana);
}
