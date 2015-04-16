package model.effect;

import model.entity.Entity;
import model.stat.Stats;
import model.map.LocalArea;

public class Bane extends Spell implements SpellEffect{
	
	private Stats currentStats;
	private Stats baseStats;
	
	public Bane(String id, Stats baseStats) {
		super(id);
		this.baseStats = baseStats;
		this.currentStats = new Stats(0,0,0,0,0,0,0,0,0);
	}
	
	@Override
	public void applyMultiplier(int m) {
		currentStats.multiplyStats(baseStats, m);
	}

	@Override
	public void applyEffect(LocalArea map, Entity entity) {
		if(canPerform()){
			decrementMana(entity);
			//TODO do this 
		}
		
	}

	@Override
	public void setCanPerform(int mana) {
		super.setCanPerform(mana);
		
	}

}
