package model.effect;

import java.util.Timer;
import java.util.TimerTask;

import model.Vector2;
import model.entity.Entity;
import model.gameTimer.GameTimer;
import model.gameTimer.GameTimerListener;
import model.stat.Stats;
import model.tile.Tile;
import model.map.GameMap;
import model.movement.EntityMovement;

public class Bane extends Spell implements SpellEffect, Projectile {

	private Stats currentStats;
	private Stats baseStats;
	private static int num = 1;

	public Bane(String id, Stats baseStats) {
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
	public void affect(Entity entity) {
		entity.mergeStats(currentStats);

	}

	@Override
	public void fire(final GameMap area, Entity entity, EntityMovement emov,
			final int radius) {

		final Vector2 faceDir = emov.getFacingDir();
		System.out.println(faceDir);
		final Vector2 pos = emov.getPosition();
		System.out.println(pos);
		final Projectile p = this;
		Tile t = area.getTile(pos);
		t.addProjectile(this);

		final GameTimer gameTimer = new GameTimer(2, true);//30 = 1 sec
		GameTimerListener l = new GameTimerListener() {

			private Tile oldt = null;
			private int numTimes = 1;
			private Tile t = area.getTile(pos);

			@Override
			public void trigger() {
				oldt = t;
				t.removeProjectile(p);
				t = area.getTileInDirection(faceDir, t);
				if (oldt == t) {
					t.removeProjectile(p);
					++num;
					gameTimer.destroy();
				}
				t.addProjectile(p);
				Boolean affect = new Boolean(false);
				t.accept(p, affect);
				if (affect.booleanValue() == true) {
					t.removeProjectile(p);
					++num;
					gameTimer.destroy();
				}
				if (radius == numTimes) {
					t.removeProjectile(p);
					++num;
					gameTimer.destroy();
				}

				numTimes++;
			}

		};
		gameTimer.addGameTimerListener(l);
		gameTimer.start();

	}

	@Override
	public void applyEffect(GameMap map, Entity entity, EntityMovement emov,
			int radius) {
		if (canPerform()) {
			decrementMana(entity);
			fire(map, entity, emov, radius);
		}
	}
}
