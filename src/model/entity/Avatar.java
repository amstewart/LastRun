package model.entity;

import java.util.ArrayList;

import visitor.AvatarVisitor;
import visitor.EntityVisitor;
import visitor.OccupationVisitor;
import visitor.VisitorContainer;
import model.entity.occupation.Occupation;
import model.entity.occupation.Sneak;
import model.entity.npc.pet.Pet;
import model.item.EquippableItem;
import model.item.TakeableItem;
import model.observer.AvatarObserver;
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
		this.occupation = new Sneak(getInventory(), getStats());// default
		ImageUtil.initSneak();
		setAssetID(ImageUtil.inEffect[2]);
	}

	public void addToInventory(TakeableItem item) {
		item.touch(this.getInventory());
	}
	
	
	@Override
	public void setName(String new_name) {
		if (new_name == null) {
			Util.errOut(new Exception("Avatar name changed to null value."),
					true);
		}
		super.setName(new_name);
	}

	@Override
	public String getDescription() {
		return DESC;
	}

	// Pre condition, getting the occupationChooser only happens in states where
	// occupationChooser was initialized
	public Occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(Occupation o) {
		this.occupation = o;
		notifyObserversOccupationHasChanged();
	}

	public Skill[] getSkills() {
		return getOccupation().getSkills();
	}

	@Override
	public void setMana(int mana) {
		super.setMana(mana);
		getOccupation().notifyManaSkills(getMana());

	}

	public void sortSkills(ArrayList<ExternalSkill> eSkills,
			ArrayList<InternalSkill> iSkills, ArrayList<SpellSkill> sSkills) {
		getOccupation().sortSkills(eSkills, iSkills, sSkills);

	}

	public void addObserver(AvatarObserver o) {
		observers.add(o);
	}

	private void notifyObserversOccupationHasChanged() {
		for (AvatarObserver o : observers) {
			o.receiveOccupation(occupation, getStats());
		}
	}
	
	@Override
	public boolean holds(String s){
		return occupation.holds(s);
	}

	@Override
	public String talk() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void accept(EntityVisitor entityVisitor,VisitorContainer container){
		System.out.println("Inside Avatar accept EntityVisitor");
		accept(new AvatarVisitor(),container);
	}
	
	public void accept(AvatarVisitor avatarVisitor, VisitorContainer container) {
		System.out.println("Inside Avatar accept avatarVisitor");
		OccupationVisitor occVisitor= new OccupationVisitor();
		occVisitor.visit(getOccupation(),container);
	}

	public boolean equip(EquippableItem equippableItem, String slotCategory) {
		return occupation.equip(equippableItem, slotCategory);
	}

	public boolean unequip(EquippableItem equippableItem, String slotCategory) {
		return occupation.unequip(equippableItem, slotCategory);
	}
}
