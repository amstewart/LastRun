package model.effect;

import model.entity.Entity;
import model.map.LocalArea;

public interface ExternalEffect extends Effect{
	public void applyMultiplier(int m);
	public void applyEffect(LocalArea map, Entity entity);
}
