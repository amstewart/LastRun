package model.effect;

import model.entity.Entity;
import model.map.GameMap;
import model.map.LocalArea;
import model.movement.EntityMovement;

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
		// TODO Auto-generated method stub
		
	}

	

}
