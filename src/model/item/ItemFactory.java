
package model.item;

/**
 *
 * @author ChrisMoscoso
 */
public class ItemFactory {
    
    
    
    public static EquippableItem  newBFSword(){
        EquippableItem item = new EquippableItem("B.F. Sword", EquipmentHandler.SMASHER_WEAPON);

        return item;
    }
    
    public static EquippableItem  newStaff(){
        EquippableItem item = new EquippableItem("Staff", EquipmentHandler.SUMMONER_WEAPON);

        return item;
    }
    
    public static EquippableItem  newCrossBow(){
        EquippableItem item = new EquippableItem("CrossBow", EquipmentHandler.SNEAK_WEAPON);

        return item;
    }
    
     public static EquippableItem  newShield(){
        EquippableItem item = new EquippableItem("Shield", EquipmentHandler.SHIELD);

        return item;
    }
}
