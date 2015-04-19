package model.effect;

import java.util.ArrayList;

import view.viewport.DialogueViewport;
import model.Describable;
import model.Vector2;
import model.entity.Entity;
import model.map.GameMap;
import model.movement.EntityMovement;
import model.tile.Tile;

public class Observe implements ExternalEffect, Describable {
	private int baseHowWrong = 100;
	private int howWrong;
	private String description = "";

	@Override
	public void applyMultiplier(int m) {
		howWrong = baseHowWrong / m;

	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getName() {
		String s = "You Observed: ";
		return s;
	}

	@Override
	public void applyEffect(GameMap map, Entity entity, EntityMovement emov,
			int radius) {
		ArrayList<Tile> tiles = map.createLocalAreaRadial(5,
				emov.getPosition());
		for (Tile t : tiles) {
			Entity observedEntity = null;
			if(t.isEntityOwner()){
				observedEntity = t.getEntity();
			}
			if (observedEntity != null) {
				description += observedEntity.getDescription() + "\n";
				int level = observedEntity.getLevel() + howWrong;
				int agility = observedEntity.getAgility() + howWrong;
				int oRating = observedEntity.getOffensiveRating() + howWrong;
				int dRating = observedEntity.getDefensiveRating() + howWrong;
				int strength = observedEntity.getStrength() + howWrong;
				int livesLeft = observedEntity.getLivesLeft() + howWrong;
				int hardiness = observedEntity.getHardiness() + howWrong;

				description += "Level: " + Integer.toString(level) + "\n";
				description += "Agility: " + Integer.toString(agility) + "\n";
				description += "Offensive Rating: " + Integer.toString(oRating) + "\n";
				description += "Defensive Rating: " + Integer.toString(dRating) + "\n";
				description += "Strength: " + Integer.toString(strength) + "\n";
				description += "Lives Left: " + Integer.toString(livesLeft)+  "\n";
				description += "Hardiness: " + Integer.toString(hardiness) + "\n";
				
				talk();
				clear();

			}
		}
	}

	private void clear() {
		description = getName();
	}

	@Override
	public String talk() {
		DialogueViewport dv = DialogueViewport.getInstance();
		dv.print(getDescription());
		return null;
	}
}
