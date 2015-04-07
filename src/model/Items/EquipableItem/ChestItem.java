/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Items.EquipableItem;

import model.inventory.EquippedInventoryManager;

/**
 *
 * @author darien
 */
public class ChestItem extends EquipableItem{

    public ChestItem(String name) {
        super(name);
    }

    @Override
    public boolean accept(EquippedInventoryManager eim) {
        
        return eim.equip(this);
    }
    
}
