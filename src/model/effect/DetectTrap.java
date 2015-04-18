package model.effect;

import java.util.Random;

import model.entity.Entity;
import model.map.GameMap;
import model.map.LocalArea;
import model.map.Trap;
import model.movement.EntityMovement;

public class DetectTrap implements ExternalEffect{
	private int baseProbability = 10;
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
