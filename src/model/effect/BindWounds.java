package model.effect;

import model.entity.Entity;

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

}
