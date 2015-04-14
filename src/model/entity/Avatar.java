/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import model.entity.occupation.Occupation;
import model.entity.occupation.Smasher;
import model.entity.occupation.Sneak;
import model.entity.occupation.Summoner;
import model.entity.npc.pet.Pet;
import model.item.OneShotItem;
import model.item.TakeableItem;
import model.item.equipment.BasicEquipment;
import model.item.equipment.Equipment;
import utility.ImageUtil;
import utility.Util;

public class Avatar extends Entity {

    private static final String DESC = "This is the player character.";

	private Pet pet;
	private Occupation occupation;

	public Avatar() { super(ImageUtil.NULL_ASSET); }

	public void beSmasher() {
		occupation = new Smasher(getInventory());
	}

	public void beSneak() {
		occupation = new Sneak(getInventory());
	}

	public void beSummoner() {
		occupation = new Summoner(getInventory());
	}

	public void changeName(String new_name) {
		if (new_name == null) { Util.errOut(new Exception("Avatar name changed to null value.")); }
		setName(new_name);
	}

	public void dropItem(TakeableItem ti) {
		this.getInventory().removeItem(ti);
	}

    @Override
    public String getDescription() {
        return DESC;
    }

	public Occupation getOccupation() {
		return occupation;
	}

	public Equipment[] getEquipment() {
		return occupation.getEquipment();
	}
}
