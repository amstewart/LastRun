package model.effect;

import model.entity.Entity;
import model.map.LocalArea;

public class Discount implements ExternalEffect{
	private double baseDiscount = .05;
	private double discount;
	
	@Override
	public void applyMultiplier(int m) {
		this.discount = baseDiscount*m;
	}

	@Override
	public void applyEffect(LocalArea map, Entity entity) {
		// TODO Auto-generated method stub
		
	}

}
