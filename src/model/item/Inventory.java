package model.item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.item.equipment.OneHandedWeapon;
import model.item.equipment.Shield;
import model.item.equipment.Staff;
import model.item.equipment.TwoHandedWeapon;

public class Inventory {
    private ArrayList<TakeableItem> items;

    public Inventory() {
        items = new ArrayList<TakeableItem>();
        items.add(new Shield());
        items.add(new OneHandedWeapon());
        items.add(new Staff());
        items.add(new TwoHandedWeapon());
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
}
