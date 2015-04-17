
package model.observer;

import model.map.GameMap;

/**
 *
 * @author ChrisMoscoso
 */
public interface MapObserver {
    public void receiveMap(GameMap map);
}
