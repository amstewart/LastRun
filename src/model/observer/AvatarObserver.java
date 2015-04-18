
package model.observer;

import model.entity.occupation.Occupation;
import model.stat.Stats;

public interface AvatarObserver {

    public void receiveOccupation(Occupation o, Stats playerStats);
    
}
