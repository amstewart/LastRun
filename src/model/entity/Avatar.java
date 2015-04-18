package model.entity;

import java.util.ArrayList;
import model.entity.occupation.Occupation;
import model.entity.occupation.Sneak;
import model.entity.npc.pet.Pet;
import model.item.TakeableItem;
import model.observer.AvatarObserver;
import model.observer.EquipmentHandlerObserver;
import model.skill.ExternalSkill;
import model.skill.InternalSkill;
import model.skill.Skill;
import model.skill.SpellSkill;
import utility.ImageUtil;
import utility.Util;

public class Avatar extends Entity {

    private ArrayList<AvatarObserver> observers = new ArrayList();
    private static final String DESC = "This is the player character.";

	private Pet pet;
	private Occupation occupation;
	private String id;

	public Avatar() {
		this.occupation = new Sneak(getInventory());//default
	}

	public void addToInventory(TakeableItem item) {
		item.touch(this.getInventory());
	}

	@Override
	public void setName(String new_name) {
		if (new_name == null) { Util.errOut(new Exception("Avatar name changed to null value."), true); }
		super.setName(new_name);
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
             notifyObserversOccupationHasChanged();
	}

	public Skill[] getSkills() {
		return getOccupation().getSkills();
	}
    
    @Override
    public void setMana(int mana){
    	super.setMana(mana);
    	getOccupation().notifyManaSkills(mana);

    }

	public void sortSkills(ArrayList<ExternalSkill> eSkills,
			ArrayList<InternalSkill> iSkills, ArrayList<SpellSkill> sSkills) {
		getOccupation().sortSkills(eSkills,iSkills,sSkills);
		
	}
        
        public void addObserver(AvatarObserver o){
            observers.add(o);
        }
        
        private void notifyObserversOccupationHasChanged(){
            for(AvatarObserver o : observers){
                o.receiveOccupation(occupation);
            }
        }
}
