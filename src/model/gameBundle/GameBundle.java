
package model.gameBundle;


import model.Vector2;
import model.entity.Avatar;
import model.entity.occupation.Occupation;
import model.item.EquipmentHandler;
import model.item.Inventory;
import model.map.GameMap;

/*
    Game class that holds all necessary components that
    states will use

    Might violate TDA as clients that use the accessors will for sure
    change the state outside of this game bundle. Shit. lol.
 */
public class GameBundle {
    
    private GameMap map;
    private Avatar avatar;
    private Occupation occupation;
    private EquipmentHandler equipmentHandler;

    public GameBundle(){
        map = new GameMap();
        avatar = new Avatar();

        avatar.setName("PLAYER");
        avatar.setMana(45);
        
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
    public EquipmentHandler getEquipmentManager() {
        equipmentHandler = occupation.getEquipmentHandler();
        return equipmentHandler;
    }
}
