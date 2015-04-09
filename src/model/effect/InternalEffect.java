package model.effect;
import model.entity.Entity;

public interface InternalEffect {
	public void applyMultiplier(int m);
	public void applyEffect(Entity entity);
}
