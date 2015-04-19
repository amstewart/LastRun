package model.skill;

import controller.keyControllers.GameController;
import model.effect.ExternalEffect;
import model.entity.Entity;
import model.map.GameMap;
import model.map.LocalArea;
import model.movement.EntityMovement;

public class ExternalSkill extends Skill{
	private ExternalEffect effect;
	private int baseRadius;
	private int radius;

	//====== TEMPORARY CONSTRUCTOR ======
	public ExternalSkill(String name, int level,ExternalEffect effect, int radius, boolean passive) {
		super(name, level, passive);
		this.effect = effect;
		this.baseRadius = radius;
	}
	@Override
	public void applyMultiplier() {
		this.radius = baseRadius * getLevel();
		effect.applyMultiplier(getLevel());
	}
	
	public void performSkill(GameMap map, Entity entity){
		applyMultiplier();
		EntityMovement emov = getMovement(entity,map);
		if(emov == null){
			return;
		}
		effect.applyEffect(map, entity, emov,radius);
	}
	
	protected EntityMovement getMovement(Entity entity, GameMap area) {
		EntityMovement emov = area.getAvatarMovement();
		if(emov != null){
			if (entity == emov.getEntity()) {
				return emov;
			}
			for (EntityMovement emovement : area.getEntityMovements()) {
				if (emovement.getEntity() == entity) {
					return emovement;// TDA violation
				}
			}
			
		}
		return null;
	}

	
	public int getRadius(){
		return radius;
	}

	
	
	
}
