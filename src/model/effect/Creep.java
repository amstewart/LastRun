package model.effect;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import utility.ImageUtil;
import model.entity.Entity;
import model.entity.Status;
import model.item.EquippableItem;

public class Creep implements InternalEffect{
	
	private int movementDecrease = 10;
	private int baseLength = 5;
	private int length;
	
	@Override
	public void applyMultiplier(int m) {
		this.length = baseLength * m;
	}

	@Override
	public void applyEffect(final Entity entity) {
		entity.addTimedStatus(Status.INVISIBLE, ImageUtil.INVISIBLE, length);
	}

	@Override
	public void applyEffect(HashMap<String, EquippableItem> equipment) {
		// mixed Instance :(
		
	}

}
