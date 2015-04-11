package model.effect;

import model.entity.Entity;
import model.map.LocalArea;

public class Observe implements ExternalEffect{
	private int baseHowWrong = 100;
	private int howWrong;
	
	@Override
	public void applyMultiplier(int m) {
		howWrong = baseHowWrong / m;
		
	}

	@Override
	public void applyEffect(LocalArea map, Entity entity) {
		// TODO Auto-generated method stub
		
	}

}
