package model.map;

import model.entity.Entity;

public class SpikeTrap extends Trap {
		
	
	public SpikeTrap(String id){
		super(id);
		damage=10;
		visible=false;
		detectionLevelRequired=3;
	}
	
	public int getDamage(){
		return damage;
	}
	
	public void apply(Entity e) {
		int life= e.getLife();
		int lifeLeft=life-damage;
		e.setLife(lifeLeft);
		this.visible = true;
	}
	
	public String toString() {
		return "Trap:SpikeTrap:" + this.visible + ":" + this.destroyed;
	}
	
}

