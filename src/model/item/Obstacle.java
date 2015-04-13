package model.item;

import model.entity.Entity;

/**
 * Created by Alex Stewart on 15/04/13.
 */
public class Obstacle extends Item {

    public Obstacle(String name) {
        super(name, 0);
    }

    @Override
    public boolean touch(Entity entity) {
        return false;   // you cannot touch an obstacle
    }
}
