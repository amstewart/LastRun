package model.areaEffect;

import model.entity.Entity;

public class EffectHandler {
	
	public void apply(AreaEffect effect, Entity e){
		effect.apply(e);
	}
}
