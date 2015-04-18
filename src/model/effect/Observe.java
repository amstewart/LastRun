package model.effect;

import model.Describable;
import model.entity.Entity;
import model.map.LocalArea;
import model.stat.Stats;

public class Observe implements ExternalEffect, Describable{
	private int baseHowWrong = 100;
	private int howWrong;
	private String description = "";
	
	@Override
	public void applyMultiplier(int m) {
		howWrong = baseHowWrong / m;
		
	}

	@Override
	public void applyEffect(LocalArea map, Entity entity) {
		Entity observedEntity = map.getEntityLinear(entity);
		if(observedEntity != null){
			Stats stats = observedEntity.getStats();
			int level = stats.getLevel() + howWrong;
			int agility= stats.getAgility()+ howWrong;
			int oRating= stats.getOffensiveRating()+ howWrong;
			int dRating= stats.getDefensiveRating()+ howWrong;
			int strength= stats.getStrength()+ howWrong;
			int livesLeft= stats.getLivesLeft()+ howWrong;
			int hardiness= stats.getHardiness()+ howWrong;
			
			description += "Level: " + Integer.toString(level);
			description += "Agility: " + Integer.toString(agility);
			description += "Offensive Rating: " + Integer.toString(oRating);
			description += "Defensive Rating: " + Integer.toString(dRating);
			description += "Strength: " + Integer.toString(strength);
			description += "Lives Left: " + Integer.toString(livesLeft);
			description += "Hardiness: " + Integer.toString(hardiness);
			
		}
		
		
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getName() {
		String s = "You Observed:\n";
		return s;
	}

}
