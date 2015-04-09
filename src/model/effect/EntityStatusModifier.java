package model.effect;

import model.entity.Entity;
import model.entity.Status;
import model.map.MiniMap;

public class EntityStatusModifier extends Spell implements ExternalEffect{
	private int baseLength;
	private int length;
	Status changeTo;
	public EntityStatusModifier(String id,Status changeTo) {
		super(id);
		this.changeTo = changeTo;
	}

	@Override
	public void applyMultiplier(int m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyEffect(MiniMap map, Entity entity) {
		// TODO Auto-generated method stub
		
	}

}
