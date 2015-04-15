package model.movement;

import model.Vector2;
import model.map.GameMap;

/**
 * Created by Alex Stewart on 15/04/09.
 */
public class Movement {

    private Vector2 position;
    private GameMap map;

    public Vector2 getPosition() { return position; }

    public Vector2 changePosition(Vector2 newPosition) {
        position = new Vector2(newPosition);
        return Vector2.subtract(newPosition, position); // return the delta
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }
    
    
}
