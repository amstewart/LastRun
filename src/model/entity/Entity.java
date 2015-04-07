package model.entity;

import model.Describable;
import model.inventory.EquippedInventoryManager;
import model.items.Inventory;
import java.util.LinkedList;

public abstract class Entity implements Describable {

    // Fields
    private EquippedInventoryManager equipment = new EquippedInventoryManager();
    private String name = "NONAME";
    private Stats stats_base = new Stats();
    private Stats stats_mod = new Stats();
	private LinkedList<Status> statuses = new LinkedList<>();
	private Inventory inventory = new Inventory();

    public void addStatus(Status status) {
        if (!statuses.contains(status))
            statuses.push(status);
    }

    public String getName() { return this.name; }

    public boolean removeStatus(Status status) {
        return statuses.remove(status);
    }
}
