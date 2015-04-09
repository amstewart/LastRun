/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import model.item.Inventory;
import model.item.Item;
import model.item.SmasherEquipmentManager;
import model.item.equipment.Chest;
import model.item.equipment.Head;
import model.item.equipment.Legs;

public class InventoryTest extends Test {

    public void run() {
        Head head = new Head("Helmet", 100);
        Chest chest = new Chest("Chest", 100);
        Legs legs = new Legs("Legs", 200);

        Inventory inventory = new Inventory();
        inventory.addItem(head);
        inventory.addItem(chest);
        inventory.addItem(legs);

        Item[] items = inventory.getItems();

        for(int i = 0; i < 3; i++) {
            System.out.println(items[i].getName());
        }


    }
}
