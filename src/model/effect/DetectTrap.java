package model.effect;

import model.entity.Entity;
import model.map.LocalArea;

public class DetectTrap implements ExternalEffect{
	private int baseProbability = 0;
	private int probability = 0;
	
	@Override
	public void applyMultiplier(int m) {
		if(probability < 100){
			probability = m * baseProbability;
		}
		
	}

	@Override
	public void applyEffect(LocalArea map, Entity entity) {
		// TODO Auto-generated method stub
		
	}
	

}
