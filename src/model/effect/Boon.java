package model.effect;

import model.entity.Entity;
import model.map.LocalArea;

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
	public void setCanPerform(int mana) {
		super.setCanPerform(mana);
		
	}

	@Override
	public void applyEffect(LocalArea map, Entity entity) {
		if(canPerform()){
			decrementMana(entity);
			entity.mergeStats(currentStats);
		}
		
	}

	
}
