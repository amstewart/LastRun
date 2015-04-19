package model.effect;

import model.entity.Entity;
import model.map.GameMap;
import model.map.LocalArea;
import model.movement.EntityMovement;
import model.stat.Stats;
import model.enums.DefinedStats;


public class Boon extends Spell implements SpellEffect{

	private Stats currentStats;
	private Stats baseStats;
	
	public Boon(String id, Stats baseStats) {
		super(id);
		this.baseStats = baseStats;
		this.currentStats = new Stats(0, 0, 0, 0, 0, 0, 0, 0, 0);
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
	public void applyEffect(GameMap map, Entity entity, EntityMovement emov,
			int radius) {
		if(canPerform()){
			decrementMana(entity);
			entity.mergeStats(currentStats);
		}
	}
}
