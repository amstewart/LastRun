/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.item.equipableItem;

import model.inventory.EquippedInventoryManager;
import model.item.TakeableItem;

/**
 *
 * @author darien
 */
public abstract class EquipableItem extends TakeableItem{

    public EquipableItem(String name) {
        super(name);
    }


    
    @Override
    public abstract  boolean accept(EquippedInventoryManager eim);
}
