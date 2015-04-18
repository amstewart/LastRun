package model.effect;

import java.util.Timer;
import java.util.TimerTask;

import model.Vector2;
import model.entity.Entity;
import model.entity.Status;
import model.stat.Stats;
import model.tile.Tile;
import model.map.GameMap;
import model.map.LocalArea;
import model.movement.EntityMovement;

public class Bane extends Spell implements SpellEffect, Projectile {

	private Stats currentStats;
	private Stats baseStats;

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
	public void applyEffect(GameMap map, Entity entity, int r) {
		if (canPerform()) {
			decrementMana(entity);
			fire(map, entity, r);
		}

	}

	@Override
	public void setCanPerform(int mana) {
		super.setCanPerform(mana);

	}

	@Override
	public void fire(GameMap area, Entity entity, int radius) {
		EntityMovement emov = getMovement(entity, area);
		if (emov == null) {
			return;
		}

		Timer timer = new Timer();
		Vector2 faceDir = emov.getFacingDir();
		Vector2 pos = emov.getPosition();
		Projectile p = this;
		Tile t = area.getTile(pos);
		t.addProjectile(this);

		TimerTask timertask = new TimerTask() {
			private Tile oldt = null;
			private int numTimes = 1;
			private Tile t = area.getTile(pos);

			@Override
			public void run() {
				oldt = t;
				t.removeProjectile(p);
				t = area.getTileInDirection(faceDir, t);
				if (oldt == t) {
					timer.cancel();
				}
				t.addProjectile(p);
				boolean affect = false;
				t.accept(p, affect);
				if (affect == true) {
					timer.cancel();
				}
				if (radius == numTimes) {
					timer.cancel();
				}
				numTimes++;
			}

		};

		timer.schedule(timertask, 0, 1000);

	}

	private EntityMovement getMovement(Entity entity, GameMap area) {
		EntityMovement emov = area.getAvatarMovement();
		if(emov != null){
			if (entity == emov.getEntity()) {
				return emov;
			}
			for (EntityMovement emovement : area.getEntityMovements()) {
				if (emovement.getEntity() == entity) {
					return emovement;// TDA violation
				}
			}
			
		}
		
		return null;
	}

	@Override
	public void affect(Entity entity) {
		entity.mergeStats(currentStats);

	}

}
