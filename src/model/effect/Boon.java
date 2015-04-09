package model.effect;

import model.entity.Entity;
import model.entity.Stats;
import model.enums.DefinedStats;


public class Boon extends Spell implements InternalEffect{
	private Stats currentStats;
	private Stats baseStats;
	
	public Boon(String id, Stats baseStats) {
		super(id);
		this.baseStats = baseStats;
	}

	@Override
	public void applyEffect(Entity entity) {
		if(canPerform(entity)){
			decrementMana();
			entity.mergeStats(currentStats);
		}
		
	}
	@Override
	public void applyMultiplier(int m) {
		// TODO MultipleBase stats and set current stats 
		
	}

	
}
