package model.effect;
import java.util.HashMap;

import model.entity.Entity;
import model.item.EquippableItem;

public interface InternalEffect {
	public void applyMultiplier(int m);
	public void applyEffect(Entity entity);
	public void applyEffect(HashMap<String, EquippableItem> equipment);
}
