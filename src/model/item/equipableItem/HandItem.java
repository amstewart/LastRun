/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.item.equipableItem;

import model.inventory.EquippedInventoryManager;

/**
 *
 * @author darien
 */
public class HandItem extends EquipableItem{

    private static final String DESC = "This is an item which is equipable to your hand.";

    public HandItem(String name) {
        super(name);
    }

    @Override
    public boolean accept(EquippedInventoryManager eim) {
        
        return eim.equip(this);
    }


    @Override
    public String getDescription() {
        return this.DESC;
    }
}
