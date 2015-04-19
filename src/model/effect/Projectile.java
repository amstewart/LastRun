package model.effect;

import model.Assetable;
import model.entity.Entity;
import model.map.GameMap;
import model.map.LocalArea;
import model.movement.EntityMovement;

public interface Projectile extends Assetable{
	
	public void affect(Entity entity);
	void fire(GameMap area, Entity entity, EntityMovement emov2, int radius);
	

}
