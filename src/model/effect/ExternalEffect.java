package model.effect;

import model.entity.Entity;
import model.map.MiniMap;

public interface ExternalEffect extends Effect{
	public void applyMultiplier(int m);
	public void applyEffect(MiniMap map, Entity entity);
}
