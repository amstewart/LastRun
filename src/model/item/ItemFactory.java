
package model.item;

import utility.ImageUtil;

/**
 *
 * @author ChrisMoscoso
 */
public class ItemFactory {
    
    
    public static NonEquippableItem newHealthPotion(){
        NonEquippableItem item = new NonEquippableItem("Health Potion");
        item.setAssetID(ImageUtil.HEALTH_POTION);
        return item;
    }
    
    public static NonEquippableItem newManaPotion(){
        NonEquippableItem item = new NonEquippableItem("Mana Potion");
        item.setAssetID(ImageUtil.MANA_POTION);
        return item;
    }
    
    public static EquippableItem  newBFSword(){
        EquippableItem item = new EquippableItem("B.F. Sword", EquipmentHandler.SMASHER_WEAPON);
        item.setAssetID(ImageUtil.SWORD);
        return item;
    }
    
    public static EquippableItem  newStaff(){
        EquippableItem item = new EquippableItem("Staff", EquipmentHandler.SUMMONER_WEAPON);
        item.setAssetID(ImageUtil.STAFF);
        return item;
    }
    
    public static EquippableItem  newCrossBow(){
        EquippableItem item = new EquippableItem("CrossBow", EquipmentHandler.SNEAK_WEAPON);
        item.setAssetID(ImageUtil.CROSSBOW);
        return item;
    }
    
     public static EquippableItem  newShield(){
        EquippableItem item = new EquippableItem("Shield", EquipmentHandler.SHIELD);
        item.setAssetID(ImageUtil.SHIELD);
        return item;
    }
}
