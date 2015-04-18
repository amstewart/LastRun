
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
    public static NonEquippableItem newCheese(){
        NonEquippableItem item = new NonEquippableItem("Cheese");
        item.setAssetID(ImageUtil.CHEESE);
        return item;
    }
    public static NonEquippableItem newBook(){
        NonEquippableItem item = new NonEquippableItem("Book");
        item.setAssetID(ImageUtil.BOOK);
        return item;
    }
    public static NonEquippableItem newKey(){
        NonEquippableItem item = new NonEquippableItem("Key");
        item.setAssetID(ImageUtil.KEY);
        return item;
    }
    public static NonEquippableItem newMushroom(){
        NonEquippableItem item = new NonEquippableItem("Mushroom");
        item.setAssetID(ImageUtil.MUSHROOM);
        return item;
    }
    public static NonEquippableItem newTorch(){
        NonEquippableItem item = new NonEquippableItem("Torch");
        item.setAssetID(ImageUtil.TORCH);
        return item;
    }
    public static NonEquippableItem newWatermelon(){
        NonEquippableItem item = new NonEquippableItem("Watermelon");
        item.setAssetID(ImageUtil.WATERMELON);
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
    public static EquippableItem  newAxe(){
        EquippableItem item = new EquippableItem("Axe - the best deoderant for men", EquipmentHandler.SMASHER_WEAPON);
        item.setAssetID(ImageUtil.AXE);
        return item;
    }
    public static EquippableItem  newBandana(){
        EquippableItem item = new EquippableItem("Bandana", EquipmentHandler.HEAD);
        item.setAssetID(ImageUtil.BANDANA);
        return item;
    }
    
    public static EquippableItem  newHelmet(){
        EquippableItem item = new EquippableItem("Helmet", EquipmentHandler.HEAD);
        item.setAssetID(ImageUtil.HELMET);
        return item;
    }
    
    public static EquippableItem  newClub(){
        EquippableItem item = new EquippableItem("Club", EquipmentHandler.SMASHER_WEAPON);
        item.setAssetID(ImageUtil.CLUB);
        return item;
    }
    public static EquippableItem  newCrossbow(){
        EquippableItem item = new EquippableItem("Crossbow", EquipmentHandler.SNEAK_WEAPON);
        item.setAssetID(ImageUtil.SWORD);
        return item;
    }
    public static EquippableItem  newDagger(){
        EquippableItem item = new EquippableItem("Dagger", EquipmentHandler.SNEAK_WEAPON);
        item.setAssetID(ImageUtil.DAGGER);
        return item;
    }
    
    public static EquippableItem  newHammer(){
        EquippableItem item = new EquippableItem("Hammer", EquipmentHandler.SMASHER_WEAPON);
        item.setAssetID(ImageUtil.HAMMER);
        return item;
    }
    
    public static EquippableItem  newMace(){
        EquippableItem item = new EquippableItem("Mace - hurts more than the spray kind", EquipmentHandler.SMASHER_WEAPON);
        item.setAssetID(ImageUtil.MACE);
        return item;
    }
    
    public static EquippableItem  newStaff(){
        EquippableItem item = new EquippableItem("Staff", EquipmentHandler.SUMMONER_WEAPON);
        item.setAssetID(ImageUtil.STAFF);
        return item;
    }
    
    public static EquippableItem  newCandyCaneStaff(){
        EquippableItem item = new EquippableItem("Santa Staff", EquipmentHandler.SUMMONER_WEAPON);
        item.setAssetID(ImageUtil.CANDYCANE_STAFF);
        return item;
    }
    
     public static EquippableItem  newShield(){
        EquippableItem item = new EquippableItem("Shield", EquipmentHandler.SHIELD);
        item.setAssetID(ImageUtil.SHIELD);
        return item;
    }
     
     public static EquippableItem  newShirt(){
        EquippableItem item = new EquippableItem("Shirt - Bought at the Gap", EquipmentHandler.CHEST);
        item.setAssetID(ImageUtil.SHIRT);
        return item;
    }
     
     public static EquippableItem getRandomHeadEquipment(){
         double chance = Math.random();
         if(chance < 0.50){
             return newBandana();
         }else{
             return newHelmet();
         }
     }
     
     public static EquippableItem getRandomSummonerWeapon(){
         double chance = Math.random();
         if(chance < 0.50){
             return newCandyCaneStaff();
         }else{
             return newStaff();
         }
     }
     
     public static EquippableItem getRandomSneakWeapon(){
         double chance = Math.random();
         if(chance < 0.50){
             return newDagger();
         }else{
             return newCrossbow();
         }
     }
     
     public static EquippableItem getRandomSmasherWeapon(){
         double chance = Math.random();
         if(chance < 0.25){
             return newBFSword();
         }
         else if(chance < 0.50){
             return newClub();
         }else if(chance < 0.75){
             return newHammer();
         }else {
             return newMace();
         }
     }
     
     public static NonEquippableItem getRandomNonEquippableItem(){
         double chance = Math.random();
         if(chance < 0.125){
             return newHealthPotion();
         }
         else if(chance < 0.25){
             return newManaPotion();
         }else if(chance < 0.375){
             return newCheese();
         }else if(chance < 0.5){
             return newMushroom();
         }else if(chance < 0.625){
             return newTorch();
         }else if(chance < 0.75){
             return newKey();
         }else if(chance < 0.875){
             return newBook();
         }else {
             return newWatermelon();
         }
     }
}
