package model.effect;

import model.entity.Entity;
import model.map.MiniMap;

public class Staff implements ExternalEffect{
	private int baseManaIncrease = 5;
	private int manaIncrease;

	@Override
	public void applyMultiplier(int m) {
		this.manaIncrease = baseManaIncrease * m;
	}

	@Override
	public void applyEffect(MiniMap map, Entity entity) {
		// TODO Auto-generated method stub
		
	}

}
