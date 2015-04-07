/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test.Inventory;

import model.Inventory.EquippedInventoryManager;
import model.Inventory.Inventory;
import model.Items.EquipableItem.ChestItem;
import model.Items.EquipableItem.HandItem;
import model.Items.EquipableItem.HeadItem;
import model.Items.TakeableItem;

/**
 *
 * @author darien
 */
public class InventoryTest {
    
    public static void main(String[] args){
        
        // Createing items:
        TakeableItem hat = new HeadItem("Hat");
        TakeableItem sword = new HandItem("Sword");
        TakeableItem machete = new HandItem("Machete");
        TakeableItem armor = new ChestItem("Armor");
        
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
        inventory.equipItem(hat, equippedInventory);
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
