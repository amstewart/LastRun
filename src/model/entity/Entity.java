/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import model.Describable;
import model.item.CoinPouch;
import model.item.Inventory;
import java.util.LinkedList;

import model.item.Inventory;

public class Entity {
    // Fields
    private CoinPouch coins = new CoinPouch();
    private String name = "NONAME";
    private Stats stats_base;
    private Stats stats_mod;
	private LinkedList<Status> statuses = new LinkedList<>();
	private Inventory inventory;

	public Entity() {
		inventory = new Inventory();
	}

    public Inventory getInventory() { return inventory; }
}
