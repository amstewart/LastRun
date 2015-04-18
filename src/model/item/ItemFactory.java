
package model.item;

import model.entity.occupation.Occupation;
import model.entity.occupation.Smasher;
import model.entity.occupation.Sneak;
import model.entity.occupation.Summoner;
import utility.ImageUtil;

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
        EquippableItem item = new EquippableItem("B.F. Sword", Smasher.SMASHER_WEAPON);
        item.setAssetID(ImageUtil.SWORD);
        return item;
    }
    public static EquippableItem  newAxe(){
        EquippableItem item = new EquippableItem("Axe - the best deoderant for men", Smasher.SMASHER_WEAPON);
        item.setAssetID(ImageUtil.AXE);
        return item;
    }
    public static EquippableItem  newBandana(){
        EquippableItem item = new EquippableItem("Bandana", Occupation.HEAD);
        item.setAssetID(ImageUtil.BANDANA);
        return item;
    }
    
    public static EquippableItem  newHelmet(){
        EquippableItem item = new EquippableItem("Helmet", Occupation.HEAD);
        item.setAssetID(ImageUtil.HELMET);
        return item;
    }
    
    public static EquippableItem  newClub(){
        EquippableItem item = new EquippableItem("Club", Smasher.SMASHER_WEAPON);
        item.setAssetID(ImageUtil.CLUB);
        return item;
    }
    public static EquippableItem  newCrossbow(){
        EquippableItem item = new EquippableItem("Crossbow", Sneak.SNEAK_WEAPON);
        item.setAssetID(ImageUtil.SWORD);
        return item;
    }
    public static EquippableItem  newDagger(){
        EquippableItem item = new EquippableItem("Dagger", Sneak.SNEAK_WEAPON);
        item.setAssetID(ImageUtil.DAGGER);
        return item;
    }
    
    public static EquippableItem  newHammer(){
        EquippableItem item = new EquippableItem("Hammer", Smasher.SMASHER_WEAPON);
        item.setAssetID(ImageUtil.HAMMER);
        return item;
    }
    
    public static EquippableItem  newMace(){
        EquippableItem item = new EquippableItem("Mace - hurts more than the spray kind", Smasher.SMASHER_WEAPON);
        item.setAssetID(ImageUtil.MACE);
        return item;
    }
    
    public static EquippableItem  newStaff(){
        EquippableItem item = new EquippableItem("Staff", Summoner.SUMMONER_WEAPON);
        item.setAssetID(ImageUtil.STAFF);
        return item;
    }
    
    public static EquippableItem  newCandyCaneStaff(){
        EquippableItem item = new EquippableItem("Santa Staff", Summoner.SUMMONER_WEAPON);
        item.setAssetID(ImageUtil.CANDYCANE_STAFF);
        return item;
    }
    
     public static EquippableItem  newShield(){
        EquippableItem item = new EquippableItem("Shield", Smasher.SHIELD);
        item.setAssetID(ImageUtil.SHIELD);
        return item;
    }
     
     public static EquippableItem  newShirt(){
        EquippableItem item = new EquippableItem("Shirt - Bought at the Gap", Occupation.CHEST);
        item.setAssetID(ImageUtil.SHIRT);
        return item;
    }
     
     public static Item getRandomItem(){
         double chance = Math.random();
         if(chance < 0.10){
             return getRandomHeadEquipment();
         }
         else if(chance < 0.20){
             return getRandomSmasherWeapon();
         }else if(chance < 0.30){
             return getRandomSummonerWeapon();
         }else if(chance < 0.40){
             return getRandomSummonerWeapon();
         }else {
             return getRandomNonEquippableItem();
         }
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
