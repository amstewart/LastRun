package model.effect;

import model.Vector2;
import model.entity.Entity;
import model.map.GameMap;
import model.map.LocalArea;
import model.movement.EntityMovement;
import model.tile.Tile;

public class Staff implements ExternalEffect{
	private int baseManaIncrease = 5;
	private int manaIncrease;

	@Override
	public void applyMultiplier(int m) {
		this.manaIncrease = baseManaIncrease * m;
	}

	@Override
	public void applyEffect(GameMap map, Entity entity, EntityMovement emov,
			int radius) {
		Vector2 pos = emov.getPosition();
		Vector2 dir = emov.getFacingDir();
		Tile oldt = map.getTile(pos);
		Tile t = map.getTileInDirection(dir, oldt);
		if(oldt == t){
			return;
		}
		
		if(t.isEntityOwner() && t.getEntity() != null){
			entity.setMana(manaIncrease);
		}
		
		
	}

	

}
