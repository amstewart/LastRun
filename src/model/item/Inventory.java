/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Inventory {
    private ArrayList<TakeableItem> items;

    public Inventory() {
        items = new ArrayList<TakeableItem>();
    }

    public boolean addItem(TakeableItem item) {
        if(item != null) {
            return items.add(item);
        }
        return false;
    }

    public boolean removeItem(TakeableItem item) {
        if(items.contains(item)) {
            return items.remove(item);
        }
        return false;
    }

    public TakeableItem[] getItems() {
        Collections.sort(items, new Comparator<TakeableItem>() {
            public int compare(TakeableItem item1, TakeableItem item2) {
                return item1.getName().compareTo(item2.getName());
            }
        });

        return items.toArray(new TakeableItem[items.size()]);
    }

    public int getSize() {
        return items.size();
    }
}
