/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Inventory;

import java.util.ArrayList;
import model.Items.EquipableItem.EquipableItem;
import model.Items.TakeableItem;

/**
 *
 * @author darien
 */
public class Inventory {
    
    private ArrayList<TakeableItem> items = new ArrayList<TakeableItem>(1);
    private int capacity;
    
    public Inventory(){
        
        capacity = 5;
    }
    
    public ArrayList<TakeableItem> getItems(){
        
        return items;
    }
    
    public boolean storeItem(TakeableItem  item ){
        
        if ( items.size() < 5 && item != null ){
            
            return items.add(item);
        }
        return false;
    }
    
    public boolean dropItem(TakeableItem item){
        
        return items.remove(item);
    }
    
    public boolean equipItem(TakeableItem item, EquippedInventoryManager  eim){
        
        if ( item instanceof EquipableItem ){
            
            EquipableItem equipableItem = (EquipableItem)item;
            if ( equipableItem.accept(eim) ){
                
                this.dropItem(equipableItem);
                return true;
            }
        }
        
        return false;
    }
    
    
}
