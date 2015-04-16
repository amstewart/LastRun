package model.effect;

import java.util.Random;

import model.entity.Entity;
import model.map.LocalArea;

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
	public void applyEffect(LocalArea map, Entity entity) {
		Random random = new Random();
		int r = random.nextInt(100);
		if(r < probability){
			map.getTrapRadial(entity);
		}

	}
}
