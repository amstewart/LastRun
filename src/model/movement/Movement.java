package model.movement;

import java.util.Observable;
import model.Vector2;
import model.map.GameMap;

/**
 * Created by Alex Stewart on 15/04/09.
 */
public class Movement extends Observable{

    private Vector2 position = Vector2.zero();
    private GameMap map;

    public Vector2 getPosition() { return new Vector2(position); }

    public void changePosition(Vector2 newPosition) {
        position = new Vector2(newPosition);
        notifyObservers();
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }
}
