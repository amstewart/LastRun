package model.effect;

import model.entity.Entity;
import model.entity.Stats;
import model.map.MiniMap;

public class Bane extends Spell implements ExternalEffect{
	
	private Stats currentStats;
	private Stats baseStats;
	
	public Bane(String id, Stats baseStats) {
		super(id);
		this.baseStats = baseStats;
	}
	
	@Override
	public void applyMultiplier(int m) {
		// TODO MultipleBase stats and set current stats 
		
	}

	@Override
	public void applyEffect(MiniMap map, Entity entity) {
		if(canPerform(entity)){
			decrementMana();
			//TODO do this 
		}
		
	}

}