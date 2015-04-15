package model.movement;

import model.Vector2;
import model.map.GameMap;

/**
 * Created by Alex Stewart on 15/04/09.
 */
public class Movement {

    private Vector2 position = Vector2.zero();
    private GameMap map;

    public Vector2 getPosition() { return position; }

    public void changePosition(Vector2 newPosition) {
        position = new Vector2(newPosition);
    }
}
