package model.effect;

import model.Asset;
import model.entity.Entity;

public class Spell extends Asset{
	private int ManaDecrease = 4;
	public Spell(String id) {
		super(id);
		
	}
	public void decrementMana(){
		// TODO Do this
	}
	
	public boolean canPerform(Entity entity){
		// TODO Do this
		return true;
	}

}
