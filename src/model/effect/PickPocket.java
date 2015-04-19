package model.effect;

import model.entity.Entity;
import model.map.GameMap;
import model.map.LocalArea;
import model.movement.EntityMovement;

public class PickPocket implements ExternalEffect{
	private int baseProbability = 0;
	private int probability = 0;
	
	@Override
	public void applyMultiplier(int m) {
		if(probability < 100){
			probability = m * baseProbability;
		}
		
	}

	@Override
	public void applyEffect(GameMap map, Entity entity, EntityMovement emov,
			int radius) {
		// TODO Auto-generated method stub
		
	}

	

}
