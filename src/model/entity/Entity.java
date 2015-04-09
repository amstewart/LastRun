/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;


import model.item.Inventory;


public class Entity {
	BagOfMoney bagOfMoney;
	Status status;
	private Inventory inventory;

	public Entity() {
		inventory = new Inventory();
	}

	public Inventory getInventory() {
		return inventory;
	}
}
