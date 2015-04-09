/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import model.inventory.EquippedInventoryManager;
import model.inventory.Inventory;
import model.item.equipableItem.ChestItem;
import model.item.equipableItem.EquipableItem;
import model.item.equipableItem.HandItem;
import model.item.equipableItem.HeadItem;
import model.item.TakeableItem;

/**
 *
 * @author darien
 */
public class InventoryTest extends Test {
    
    public void run() {
        
        // Createing items:
        EquipableItem hat = new HeadItem("Hat");
        EquipableItem sword = new HandItem("Sword");
        EquipableItem machete = new HandItem("Machete");
        EquipableItem armor = new ChestItem("Armor");
        
        // Create Inventories
        Inventory inventory = new Inventory();
        EquippedInventoryManager equippedInventory = new EquippedInventoryManager();
        
        inventory.storeItem(hat);
        inventory.storeItem(sword);
        printInventoryItems(inventory);
        
        inventory.dropItem(hat);
        inventory.dropItem(sword);
        inventory.dropItem(armor);
        printInventoryItems(inventory);
        
        inventory.storeItem(hat);
        inventory.storeItem(sword);
        
        // Hat should no be
        inventory.equipItem(hat,equippedInventory);
        printEquippedInventoryItems(equippedInventory);
        printInventoryItems(inventory);
        
        System.out.println("\nUnequipping Item: Hat");
        equippedInventory.unequipHeadItem(inventory);
        printEquippedInventoryItems(equippedInventory);
        printInventoryItems(inventory);
        
        equippedInventory.unequiChestItem();
    }
    
    private static void printInventoryItems(Inventory inv){
        
        System.out.println("Iventory: ");
        if (inv.getItems().size() <= 0){
            
            System.out.println("Inventor is empty" );
            return;
        }
        
        for (TakeableItem i : inv.getItems() ){
            
            System.out.println("Item: " + i.getName() );
        }
    }
    
    private static void printEquippedInventoryItems(EquippedInventoryManager inv){
        
        System.out.println("Equipped Inventory:");
        if (inv.getItems().size() <= 0){
            
            System.out.println("Equipped is empty" );
            return;
        }
        for (TakeableItem i : inv.getItems() ){
            
            
                System.out.println("Item: " + i.getName() );
        }
    }
    
}
