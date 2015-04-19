package model.effect;

import java.util.Random;

import model.Vector2;
import model.entity.Entity;
import model.map.GameMap;
import model.map.LocalArea;
import model.movement.EntityMovement;
import model.tile.Tile;

public class PickPocket implements ExternalEffect {
	private int baseProbability = 0;
	private int probability = 0;

	@Override
	public void applyMultiplier(int m) {
		if (probability < 100) {
			probability = m * baseProbability;
		}

	}

	@Override
	public void applyEffect(GameMap map, Entity entity, EntityMovement emov,
			int radius) {
		Random random = new Random();
		int m = random.nextInt(100 - 1 + 1) + 1;
		if (m < probability) {
			Vector2 pos = emov.getPosition();
			Vector2 dir = emov.getFacingDir();
			Tile oldt = null;

			Tile t = map.getTile(pos);

			for (int i = 0; i != radius; ++i) {
				oldt = t;
				t = map.getTileInDirection(dir, t);
				if (oldt == t) {
					break;
				}
				if(t.isEntityOwner()){
					Entity e = t.getEntity();
					entity.rob(e);
					break;
				}
			}

		}

	}

}
