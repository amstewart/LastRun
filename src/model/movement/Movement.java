package model.movement;

import model.Vector3;
import model.map.GameMap;

/**
 * Created by Alex Stewart on 15/04/09.
 */
public class Movement {

    private Vector3 position;
    private GameMap map;

    public Vector3 getPosition() { return position; }

    public void moveTo(Vector3 newPosition) {
        position = newPosition;
    }
}
