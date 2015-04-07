/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Items.EquipableItem;

import model.inventory.EquippedInventoryManager;
import model.Items.Item;
import model.Items.TakeableItem;

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
