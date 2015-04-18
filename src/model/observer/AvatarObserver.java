
package model.observer;

import model.entity.occupation.Occupation;

/**
 *
 * @author ChrisMoscoso
 */
public interface AvatarObserver {

    public void receiveOccupation(Occupation o);
    
}
