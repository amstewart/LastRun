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
    public void fire(final GameMap area, Entity entity, final int radius) {
        EntityMovement emov = getMovement(entity, area);
        if (emov == null) {
            return;
        }

        final Vector2 faceDir = emov.getFacingDir();
        final Vector2 pos = emov.getPosition();
        final Projectile p = this;
        Tile t = area.getTile(pos);
        t.addProjectile(this);
        
        final GameTimer gameTimer = new GameTimer(10, true);
        GameTimerListener l = new GameTimerListener() {

            private Tile oldt = null;
            private int numTimes = 1;
            private Tile t = area.getTile(pos);

            @Override
            public void trigger() {
                System.out.println("FIRE APPLE!");
                oldt = t;
                t.removeProjectile(p);
                t = area.getTileInDirection(faceDir, t);
                if (oldt == t) {
                    t.removeProjectile(p);
                    ++num;
                    gameTimer.pause();
                }
                t.addProjectile(p);
                boolean affect = false;
                t.accept(p, affect);
                if (affect == true) {
                    t.removeProjectile(p);
                    ++num;
                    gameTimer.pause();
                }
                if (radius == numTimes) {
                    t.removeProjectile(p);
                    ++num;
                    gameTimer.pause();
                }

                numTimes++;
            }

        };
        gameTimer.addGameTimerListener(l);
        gameTimer.start();

    }

    private EntityMovement getMovement(Entity entity, GameMap area) {
        EntityMovement emov = area.getAvatarMovement();
        if (emov != null) {
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
