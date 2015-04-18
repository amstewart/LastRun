package model.effect;

import model.Assetable;
import model.entity.Entity;
import model.map.GameMap;
import model.map.LocalArea;

public interface Projectile extends Assetable{
	
	public void fire(GameMap area,Entity entity, int radius);
	public void affect(Entity entity);
	

}
