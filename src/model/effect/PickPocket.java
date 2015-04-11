package model.effect;

import model.entity.Entity;
import model.map.MiniMap;

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
	public void applyEffect(MiniMap map, Entity entity) {
		// TODO Auto-generated method stub
		
	}

}
