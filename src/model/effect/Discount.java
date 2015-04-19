package model.effect;

import model.entity.Entity;
import model.map.GameMap;
import model.map.LocalArea;
import model.movement.EntityMovement;

public class Discount implements ExternalEffect{
	private double baseDiscount = .05;
	private double discount;
	
	@Override
	public void applyMultiplier(int m) {
		this.discount = baseDiscount*m;
	}

	@Override
	public void applyEffect(GameMap map, Entity entity, EntityMovement emov,
			int radius) {
		// TODO Auto-generated method stub
		
	}


}
