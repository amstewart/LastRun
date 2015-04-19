
package model.observer;

import model.Vector2;
import model.map.GameMap;

/**
 *
 * @author ChrisMoscoso
 */
public interface MapObserver {
    public void receiveMap(GameMap map);

    public void receiveNonStealthAvatarPosition(Vector2 v);
}
