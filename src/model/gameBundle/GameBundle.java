
package model.gameBundle;

import model.entity.Avatar;
import model.map.GameMap;

/**
 *
 * @author ChrisMoscoso
 */
public class GameBundle {
    
    GameMap map;
    Avatar avatar;
    
    public GameBundle(){
        map = new GameMap();
        avatar = new Avatar();
    }
    
    public void selectOccupation(){
        
    }

    public GameMap getMap() {
        return map;
    }

    public Avatar getAvatar() {
        return avatar;
    }
    
    
}
