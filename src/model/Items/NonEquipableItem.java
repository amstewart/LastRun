/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Items;

import model.inventory.EquippedInventoryManager;

/**
 *
 * @author darien
 */
public abstract class NonEquipableItem extends TakeableItem{
    
    public NonEquipableItem(String name){
        
        super(name);
    }
    
    @Override
    public abstract  boolean accept(EquippedInventoryManager eim);
}
