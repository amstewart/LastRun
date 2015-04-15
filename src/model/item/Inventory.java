package model.item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.item.equipment.OneHandedWeapon;
import model.item.equipment.Shield;
import model.item.equipment.Staff;
import model.item.equipment.TwoHandedWeapon;
import view.viewport.InventoryViewport;

public class Inventory {
    private ArrayList<TakeableItem> items;
    private ArrayList<InventoryViewport> registeredViews;

    public Inventory() {
        items = new ArrayList<TakeableItem>();
        registeredViews = new ArrayList<InventoryViewport>();
        items.add(new Shield());
        items.add(new OneHandedWeapon());
        items.add(new Staff());
        items.add(new TwoHandedWeapon());
    }

    public void registerView(InventoryViewport view) {
        registeredViews.add(view);
    }

    private void notifyViews() {
        for(InventoryViewport views: registeredViews) {
            views.receive(this.getItems());
        }
    }
    public boolean addItem(TakeableItem item) {
        if(item != null) {
            notifyViews();
            return items.add(item);
        }
        return false;
    }

    public boolean removeItem(TakeableItem item) {
        if(items.contains(item)) {
            items.remove(item);
            notifyViews();
            return true;
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
