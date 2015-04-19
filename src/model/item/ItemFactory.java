
package model.item;

import model.entity.occupation.Occupation;
import model.entity.occupation.Smasher;
import model.entity.occupation.Sneak;
import model.entity.occupation.Summoner;
import model.enums.DefinedStats;
import model.map.GameMap;
import model.map.MapBuilder;
import model.stat.Stats;
import utility.ImageUtil;

public class ItemFactory {
    
    public static NonEquippableItem newHealthPotion(){
        NonEquippableItem item = new NonEquippableItem("Health Potion");
        Stats itemStats = DefinedStats.ADDHEALTH.getStats();
        item.setItemStats(itemStats);
        item.setAssetID(ImageUtil.HEALTH_POTION);

        return item;
    }

    public static NonEquippableItem newBook(){
        NonEquippableItem item = new NonEquippableItem("Book");
        Stats itemStats = DefinedStats.ADDINTELLECT.getStats();
        item.setItemStats(itemStats);
        item.setAssetID(ImageUtil.BOOK);

        return item;
    }

    public static NonEquippableItem newMushroom(){
        NonEquippableItem item = new NonEquippableItem("Mushroom");
        Stats itemStats = DefinedStats.MINUSHEALTH.getStats();
        item.setItemStats(itemStats);
        item.setAssetID(ImageUtil.MUSHROOM);
        return item;
    }

    public static NonEquippableItem newTorch(){
        NonEquippableItem item = new NonEquippableItem("Torch");
        Stats itemStats = DefinedStats.DEFAULTSTATS.getStats();
        item.setItemStats(itemStats);
        item.setAssetID(ImageUtil.TORCH);
        return item;
    }

    public static NonEquippableItem newWatermelon(){
        NonEquippableItem item = new NonEquippableItem("Watermelon");
        Stats itemStats = DefinedStats.ADDHEALTH.getStats();
        item.setItemStats(itemStats);
        item.setAssetID(ImageUtil.WATERMELON);
        return item;
    }

    
    public static NonEquippableItem newManaPotion(){
        NonEquippableItem item = new NonEquippableItem("Mana Potion");
        Stats itemStats = DefinedStats.DEFAULTSTATS.getStats();
        item.setItemStats(itemStats);
        item.setAssetID(ImageUtil.MANA_POTION);
        return item;
    }

    public static NonEquippableItem newGoldBar() {
        NonEquippableItem item = new NonEquippableItem("Secret Gold Bar");
        Stats itemStats = DefinedStats.DEFAULTSTATS.getStats();
        item.setAssetID(ImageUtil.GOLDBAR);

        return item;
    }
    //=========== 3 types of Basic Head Equipment ===========
    public static EquippableItem  newHelmet(){
        EquippableItem item = new EquippableItem("Helmet", Occupation.HEAD);
        Stats stats = DefinedStats.ADDHEADARMOR.getStats();
        item.setItemStats(stats);
        item.setAssetID(ImageUtil.HELMET);
        return item;
    }

    public static EquippableItem  newBandana(){
        EquippableItem item = new EquippableItem("Bandana", Occupation.HEAD);
        Stats stats = DefinedStats.ADDHEADARMOR.getStats();
        item.setItemStats(stats);
        item.setAssetID(ImageUtil.BANDANA);
        return item;
    }

    public static EquippableItem newCap() {
        EquippableItem item = new EquippableItem("BaseballCap - protects the eyes from the sun", Occupation.HEAD);
        Stats stats = DefinedStats.ADDHEADARMOR.getStats();
        item.setItemStats(stats);
        item.setAssetID(ImageUtil.CAP);

        return item;
    }

    //=========== 3 types of Basic Chest Equipment ============

    public static EquippableItem  newChest1(){
        EquippableItem item = new EquippableItem("Shirt - Bought at the Gap", Occupation.CHEST);
        Stats stats = DefinedStats.ADDCHESTARMOR.getStats();
        item.setItemStats(stats);
        item.setAssetID(ImageUtil.SHIRT);
        return item;
    }

    public static EquippableItem newChest2() {
        EquippableItem item = new EquippableItem("Chest", Occupation.CHEST);
        Stats stats = DefinedStats.ADDCHESTARMOR.getStats();
        item.setItemStats(stats);
        // TODO: ADD IMAGE ASSET
        return item;
    }

    public static EquippableItem newChest3() {
        EquippableItem item = new EquippableItem("Bullet Proof Vest", Occupation.CHEST);
        Stats stats = DefinedStats.ADDCHESTARMOR.getStats();
        item.setItemStats(stats);
        //TODO: Add Image ASSET
        return item;
    }

    //=========== 3 types of Basic Leg Equipment ==============
    public static EquippableItem  newLegs1(){
        EquippableItem item = new EquippableItem("Leggings", Occupation.LEGS);
        Stats stats = DefinedStats.ADDLEGARMOR.getStats();
        item.setItemStats(stats);
        item.setAssetID(ImageUtil.SHIRT);
        return item;
    }

    public static EquippableItem newLegs2() {
        EquippableItem item = new EquippableItem("Joggers", Occupation.LEGS);
        Stats stats = DefinedStats.ADDLEGARMOR.getStats();
        item.setItemStats(stats);
        // TODO: ADD IMAGE ASSET
        return item;
    }

    public static EquippableItem newLegs3() {
        EquippableItem item = new EquippableItem("Skinny Fit jeans", Occupation.LEGS);
        Stats stats = DefinedStats.ADDLEGARMOR.getStats();
        item.setItemStats(stats);
        //TODO: Add Image ASSET
        return item;
    }

    //=========== 3 types of Summoner Equipment ===============

    public static EquippableItem  newStaff(){
        EquippableItem item = new EquippableItem("Staff", Summoner.SUMMONER_WEAPON);
        Stats stats = DefinedStats.SUMWEAPONSTATS1.getStats();
        item.setItemStats(stats);
        item.setAssetID(ImageUtil.STAFF);
        return item;
    }

    public static EquippableItem  newCandyCaneStaff(){
        EquippableItem item = new EquippableItem("Santa Staff", Summoner.SUMMONER_WEAPON);
        Stats stats = DefinedStats.SUMWEAPONSTATS2.getStats();
        item.setItemStats(stats);
        item.setAssetID(ImageUtil.CANDYCANE_STAFF);
        return item;
    }

    public static EquippableItem newWeirdStaff() {
        EquippableItem item = new EquippableItem("Weird Staff", Summoner.SUMMONER_WEAPON);
        Stats stats = DefinedStats.SUMWEAPONSTATS3.getStats();
        item.setItemStats(stats);
        item.setAssetID(ImageUtil.WERID_STAFF);
        return item;
    }

    //=========== 3 types of Smasher Equipment ================

    public static EquippableItem  newBFSword(){
        EquippableItem item = new EquippableItem("B.F. Sword", Smasher.SMASHER_WEAPON);
        Stats stats = DefinedStats.SMASHERWEAPONSTATS1.getStats();
        item.setItemStats(stats);
        item.setAssetID(ImageUtil.SWORD);
        return item;
    }

    public static EquippableItem  newAxe(){
        EquippableItem item = new EquippableItem("Axe - the best deoderant for men", Smasher.SMASHER_WEAPON);
        Stats stats = DefinedStats.SMASHERWEAPONSTATS3.getStats();
        item.setItemStats(stats);
        item.setAssetID(ImageUtil.AXE);
        return item;
    }

    public static EquippableItem  newClub(){
        EquippableItem item = new EquippableItem("Club", Smasher.SMASHER_WEAPON);
        Stats stats = DefinedStats.SMASHERWEAPONSTATS2.getStats();
        item.setItemStats(stats);
        item.setAssetID(ImageUtil.CLUB);
        return item;
    }

    public static EquippableItem  newHammer(){
        EquippableItem item = new EquippableItem("Hammer", Smasher.SMASHER_WEAPON);
        Stats stats = DefinedStats.SMASHERWEAPONSTATS1.getStats();
        item.setItemStats(stats);
        item.setAssetID(ImageUtil.HAMMER);
        return item;
    }

    public static EquippableItem  newMace(){
        EquippableItem item = new EquippableItem("Mace - hurts more than the spray kind", Smasher.SMASHER_WEAPON);
        Stats stats = DefinedStats.SMASHERWEAPONSTATS1.getStats();
        item.setItemStats(stats);
        item.setAssetID(ImageUtil.MACE);
        return item;
    }

    public static EquippableItem  newShield(){
        EquippableItem item = new EquippableItem("Shield", Smasher.SHIELD);
        Stats stats = DefinedStats.ADDHEADARMOR.getStats();
        item.setItemStats(stats);
        item.setAssetID(ImageUtil.SHIELD);
        return item;
    }

    //=========== 3 types of Sneak Equipment ==================

    public static EquippableItem  newCrossbow(){
        EquippableItem item = new EquippableItem("Crossbow", Sneak.SNEAK_WEAPON);
        Stats stats = DefinedStats.SNEAKWEAPONSTATS1.getStats();
        item.setItemStats(stats);
        item.setAssetID(ImageUtil.SWORD);

        return item;
    }
    public static EquippableItem  newDagger(){
        EquippableItem item = new EquippableItem("Dagger", Sneak.SNEAK_WEAPON);
        Stats stats = DefinedStats.SNEAKWEAPONSTATS2.getStats();
        item.setItemStats(stats);
        item.setAssetID(ImageUtil.DAGGER);

        return item;
    }

    public static EquippableItem newCheese(){
        EquippableItem item = new EquippableItem("Expired Cheese - makes foes run away", Sneak.SNEAK_WEAPON);
        Stats stats = DefinedStats.DEFAULTSTATS.getStats();
        item.setItemStats(stats);
        item.setAssetID(ImageUtil.CHEESE);

        return item;
    }

    // =========== Activation Items ========================

    public static ActivationItem newKey1() {
        ActivationItem item = new ActivationItem("Key to Open chest");
        item.setInteractionID(1);
        item.setAssetID(ImageUtil.KEY);

        return item;
    }

    public static ActivationItem newKey2() {
        ActivationItem item = new ActivationItem("Key to Open chest");
        item.setInteractionID(2);
        item.setAssetID(ImageUtil.KEY);

        return item;
    }

    public static ActivationItem newKey3() {
        ActivationItem item = new ActivationItem("Key to Open chest");
        item.setInteractionID(3);
        item.setAssetID(ImageUtil.KEY);

        return item;
    }

    // ============ Interaction Item =======================

    public static InteractiveItem newClosedChest() {
        InteractiveItem item = new InteractiveItem("Door");
        item.setAssetID(ImageUtil.CLOSEDCHEST);
        item.setActivationId(1);

        return item;
    }

    public static InteractiveItem newOpenedChest() {
        InteractiveItem item = new InteractiveItem("Door");
        item.setAssetID(ImageUtil.OPENCHEST);
        item.setActivationId(1);

        return item;
    }

    // ============ Random Item Generator ===================
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
     
     public static ActivationItem getRandomKey() {
         double change = Math.random();
         if(change < 0.30) {
             return newKey1();
         } else if(change < 0.50) {
             return newKey2();
         } else {
             return newKey3();
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
         else if(chance < 0.375){
             return newCheese();
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
         }else if(chance < 0.5){
             return newMushroom();
         }else if(chance < 0.625){
             return newTorch();
         }else if(chance < 0.875){
             return newBook();
         }else {
             return newWatermelon();
         }
     }
}
