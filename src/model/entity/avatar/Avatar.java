/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity.avatar;


import model.entity.Entity;
import model.entity.occupation.Occupation;
import model.entity.occupation.Smasher;
import model.entity.occupation.Sneak;
import model.entity.occupation.Summoner;
import model.entity.npc.pet.Pet;
import model.item.TakeableItem;
import model.item.equipment.Equipment;
import utility.ImageUtil;

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

    @Override
    public String getDescription() {
        return DESC;
    }
    
    @Override
    public void setMana(int mana){
    	super.setMana(mana);
    	occupation.notifySkills(mana);
    	
    }

	public boolean addToInventory(TakeableItem item) {
		return getInventory().addItem(item);
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public TakeableItem[] getInventoryItems() {
		return getInventory().getItems();
	}

	public Equipment[] getEquipment() {
		return occupation.getEquipment();
	}
}
