package model.effect;

import model.entity.Entity;

public class Creep implements InternalEffect{
	
	private int baseLength = 2;
	private int length;
	
	@Override
	public void applyMultiplier(int m) {
		this.length = baseLength * m;
		
	}

	@Override
	public void applyEffect(Entity entity) {
		// TODO Auto-generated method stub
		
	}

}
