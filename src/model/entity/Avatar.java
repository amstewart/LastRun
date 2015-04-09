/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import model.items.EquippedItems;

public class Avatar extends Entity {
	Pet pet;
	EquippedItems equippedItems;
	Occupation occupation;

    public String getDescription() { return "I am an avatar."; } //TODO Make better.
}
