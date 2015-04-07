/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Items.EquipableItem;

import model.Inventory.EquippedInventoryManager;
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
    
    public abstract  boolean accept(EquippedInventoryManager eim);
}
