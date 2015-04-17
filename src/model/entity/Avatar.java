package model.entity;

import java.util.ArrayList;
import model.entity.occupation.Occupation;
import model.entity.occupation.Sneak;
import model.entity.npc.pet.Pet;
import model.item.TakeableItem;
import model.item.equipment.Equipment;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;
import utility.ImageUtil;
import utility.Util;

public class Avatar extends Entity {

    private static final String DESC = "This is the player character.";

	private Pet pet;
	private Occupation occupation;
	private String id;

	public Avatar() {
		this.occupation = new Sneak(getInventory());//default
	}

	public boolean addToInventory(TakeableItem item) {
		return getInventory().addItem(item);
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
		return occupation;
	}

	public void setOccupation(Occupation o){
		this.occupation = o;
	}

	public Equipment[] getEquipment() {
		return getOccupation().getEquipment();
	}

	public TakeableItem[] getInventoryItems() {
		return getInventory().getItems();
	}

	public Skill[] getSkills() {
		return getOccupation().getSkills();
	}
    
    @Override
    public void setMana(int mana){
    	super.setMana(mana);
    	getOccupation().notifySkills(mana);

    }

	public void sortSkills(ArrayList<ExternalSkill> eSkills,
			ArrayList<InternalSkill> iSkills, ArrayList<SpellSkill> sSkills) {
		getOccupation().sortSkills(eSkills,iSkills,sSkills);
		
	}
}
