package model.effect;

import java.util.Timer;
import java.util.TimerTask;

import utility.ImageUtil;
import model.Vector2;
import model.entity.Entity;
import model.entity.Status;
import model.map.GameMap;
import model.map.LocalArea;
import model.movement.EntityMovement;
import model.tile.Tile;

public class EntityStatusModifier extends Spell implements SpellEffect, Projectile{
	private int baseLength;
	private int length;
	Status changeTo;
	String assetID;
	public EntityStatusModifier(String id,Status changeTo, String AssetId) {
		super(id);
		this.changeTo = changeTo;
		this.assetID = AssetId;
	}

	@Override
	public void applyMultiplier(int m) {
		length = baseLength * m;
		
	}

	
	
	
	
	@Override
	public void setCanPerform(int mana) {
		super.setCanPerform(mana);
		
	}

	@Override
	public void fire(final GameMap area, Entity entity, EntityMovement emov, final int radius) {

		final Timer timer = new Timer();
		final Vector2 faceDir = emov.getFacingDir();
		final Vector2 pos = emov.getPosition();
		final Projectile p = this;
		Tile t = area.getTile(pos);
		t.addProjectile(this);

		TimerTask timertask = new TimerTask() {
			private Tile oldt = null;
			private int numTimes = 1;
			private Tile t = area.getTile(pos);
			private boolean affect= false;

			@Override
			public void run() {
				oldt = t;
				t.removeProjectile(p);
				t = area.getTileInDirection(faceDir, t);
				if (oldt == t) {
					t.removeProjectile(p);
					timer.cancel();
				}
				t.addProjectile(p);
				t.accept(p, affect);
				if (affect == true) {
					t.removeProjectile(p);
					timer.cancel();
				}
				if (radius == numTimes) {
					t.removeProjectile(p);
					timer.cancel();
				}
				
				numTimes++;
				
			}

		};

		timer.schedule(timertask, 0, 66);

	}

	@Override
	public void affect(Entity entity) {
		entity.addTimedStatus(changeTo,assetID,length);
		
	}

	@Override
	public void applyEffect(GameMap map, Entity entity, EntityMovement emov,
			int radius) {
		fire(map,entity,emov,radius);
		
	}

}
