/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Inventory;

import java.util.ArrayList;
import model.Items.EquipableItem.ChestItem;
import model.Items.EquipableItem.EquipableItem;
import model.Items.EquipableItem.HandItem;
import model.Items.EquipableItem.HeadItem;


/**
 *
 * @author darien
 */
public class EquippedInventoryManager {
    
    private HeadItem headItem = null;
    private HandItem rightHandItem = null;
    private HandItem leftHandItem = null;
    private ChestItem chestItem = null;
    ArrayList<EquipableItem> items = new ArrayList<EquipableItem>(1);
    
    public EquippedInventoryManager(){
       
       
    }
    
     public ArrayList<EquipableItem> getItems(){
        
        return items;
    }
    
    public boolean equip(HeadItem item ){
        
        if ( headItem == null){
            
            headItem = item;
            items.add(item);
            return true;
        }
        return false;
    }
    
    public boolean equip(ChestItem item ){
        
        if ( chestItem == null){
            chestItem = item;
            items.add(item);
            return true;
        }
        return false;
    }
    
    public boolean equip(HandItem item ){
        
        if ( rightHandItem == null){
            rightHandItem  = item;
            return true;
        }
        else if ( leftHandItem == null ){
            
            leftHandItem = item;
            items.add(item);
            return true;
        }
        return false;
    }
    
    public boolean unequipHeadItem(Inventory inventory){
        
        if ( inventory.storeItem(headItem) ){
            
            items.remove(headItem);
            headItem = null;
            return true;
        }
        return false; 
    }
    
    public EquipableItem unequiChestItem(){
        
        EquipableItem item = chestItem;
        chestItem = null;
        items.remove(item);
        return item;   
    }
    
    public EquipableItem unequiLeftHandItem(){
        
        EquipableItem item = leftHandItem;
        leftHandItem = null;
        items.remove(item);
        return item;   
    }
    
    public EquipableItem unequiRightHandItem(){
        
        EquipableItem item = rightHandItem;
        rightHandItem = null;
        items.remove(item);
        return item;   
    }
    
    
    
}
