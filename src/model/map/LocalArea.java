package model.map;

import java.util.ArrayList;

import model.Vector2;
import model.entity.Entity;
import model.movement.Movement;
import model.tile.Tile;

public class LocalArea {
	Vector2 center ;
	ArrayList<Tile> list;
	Movement movement;
	
	public LocalArea(Vector2 center, ArrayList<Tile> list){
		this.center = center;
		this.list = list;
	}
	
	public Entity getEntityLinear(Entity entity){ 
		return null;
	}
	

	
	
	public Trap getTrapRadial(Entity entity){
		return null;
	}

	public Trap removeTrapLinear(Entity entity, int radius) {
		return null;
	}
}
