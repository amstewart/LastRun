
package model.gameBundle;

import model.entity.Avatar;
import model.entity.OccupationChooser;
import model.item.Inventory;
import model.map.GameMap;
import model.stat.Stats;

/*
    Game class that holds all necessary components that
    states will use
 */
public class GameBundle {
    
    GameMap map;
    Avatar avatar;
    
    public GameBundle(){
        map = new GameMap();
        avatar = new Avatar();
    }
    
    public OccupationChooser getOccupationChooser() {
        return avatar.getOccupationChooser();
    }

    public Inventory getInventory() {
        return avatar.getInventory();
    }

    public GameMap getMap() {
        return map;
    }

    public Avatar getAvatar() {
        return avatar;
    }
    
    
}
