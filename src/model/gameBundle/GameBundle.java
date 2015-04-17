
package model.gameBundle;


import model.Vector2;
import model.entity.Avatar;
import model.entity.OccupationChooser;
import model.entity.occupation.Occupation;
import model.enums.DefinedStats;
import model.item.EquipmentManager;
import model.item.Inventory;
import model.map.GameMap;
import model.stat.Stats;

/*
    Game class that holds all necessary components that
    states will use


    Might violate TDA as clients that use the accessors will for sure
    change the state outside of this game bundle. Shit. lol.
 */
public class GameBundle {
    
    private GameMap map;
    private Avatar avatar;
    private OccupationChooser occupationChooser;
    private Occupation occupation;
    private EquipmentManager equipmentManager;

    public GameBundle(){
        map = new GameMap();
        avatar = new Avatar();
        map.addEntity(avatar,new Vector2(0,0));
  
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

    // These functions have to be called at specfic times because some parts
    // will be null until user takes action to set them.

    // pre condition: occupation should have been chosen
    public Occupation getOccupation() {
        occupation = avatar.getOccupation();
        return occupation;
    }
    // pre condition is occupation is chose before accessing equipment
    public EquipmentManager getEquipmentManager() {
        equipmentManager = occupation.getEquipmentManager();
        return equipmentManager;
    }
}
