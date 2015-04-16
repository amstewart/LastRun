/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import model.entity.occupation.Occupation;
import model.entity.npc.pet.Pet;
import model.item.TakeableItem;
import model.item.equipment.Equipment;
import model.skill.Skill;
import utility.ImageUtil;
import utility.Util;

public class Avatar extends Entity {

    private static final String DESC = "This is the player character.";

	private Pet pet;
	private OccupationChooser occupationChooser;

	public Avatar() {
		super(ImageUtil.NULL_ASSET);
		occupationChooser = new OccupationChooser(this);
	}

	public void changeName(String new_name) {
		if (new_name == null) { Util.errOut(new Exception("Avatar name changed to null value."), true); }
		setName(new_name);
	}

    @Override
    public String getDescription() {
        return DESC;
    }
	// Pre condition, getting the occupationChooser only happens in states where occupationChooser was initialized
	public Occupation getOccupation() {
		return occupationChooser.getOccupation();
	}

	public OccupationChooser getOccupationChooser() {
		return occupationChooser;
	}
	public Equipment[] getEquipment() {
		return getOccupation().getEquipment();
	}

	public Skill[] getSkills() {
		return getOccupation().getSkills();
	}
    
    @Override
    public void setMana(int mana){
    	super.setMana(mana);
    	getOccupation().notifySkills(mana);
    	
    }

	public boolean addToInventory(TakeableItem item) {
		return getInventory().addItem(item);
	}


	public TakeableItem[] getInventoryItems() {
		return getInventory().getItems();
	}
}
