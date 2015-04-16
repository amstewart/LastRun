package model.effect;

import model.entity.Entity;
import model.map.MiniMap;
import model.stat.Stats;
import model.enums.DefinedStats;


public class Boon extends Spell implements SpellEffect{
	private Stats currentStats;
	private Stats baseStats;
	
	public Boon(String id, Stats baseStats) {
		super(id);
		this.baseStats = baseStats;
	}

	@Override
	public void applyMultiplier(int m) {
		currentStats.multiplyStats(baseStats, m);
	}

	@Override
	public void applyEffect(MiniMap map, Entity entity) {
		if(canPerform()){
			decrementMana(entity);
			entity.mergeStats(currentStats);
		}
		
	}
	@Override
	public void setCanPerform(int mana) {
		super.setCanPerform(mana);
		
	}

	
}
