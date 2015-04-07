package model.entity;

import model.inventory.EquippedInventoryManager;
import model.items.Inventory;
import java.util.LinkedList;

public class Entity {

    // Fields
    private EquippedInventoryManager equipment = new EquippedInventoryManager();
    private String name = "NONAME";
    private Stats stats_base = new Stats();
    private Stats stats_mod = new Stats();
	private LinkedList<Status> statuses = new LinkedList<>();
	private Inventory inventory = new Inventory();
}
