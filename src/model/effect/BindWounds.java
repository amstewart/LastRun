package model.effect;

import java.util.HashMap;

import model.entity.Entity;
import model.item.EquippableItem;

public class BindWounds implements InternalEffect{

	private int baseStrengthIncrease = 5;
	private int strengthIncrease;
	
	@Override
	public void applyMultiplier(int m) {
		this.strengthIncrease = m * baseStrengthIncrease;
	}

	@Override
	public void applyEffect(Entity entity) {
		entity.setStrength(strengthIncrease);
	}

	@Override
	public void applyEffect(HashMap<String, EquippableItem> equipment) {
		// mixed Instance :(
		
	}

}
