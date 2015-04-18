package model.map;

import java.util.ArrayList;

import model.Vector2;
import model.entity.Entity;
import model.movement.Movement;
import model.tile.Tile;

public class LocalArea extends GameMap {
	Vector2 center;
	ArrayList<Tile> list;
	Movement movement;
	int radius;

	public Tile getTileAtCenter() {
		return getTile(center);
	}

	
	public int getRadius(){
		return radius;
	}
	public LocalArea(Vector2 center, ArrayList<Tile> list, int radius) {
		this.center = center;
		this.list = list;
		this.radius = radius;
	}

	public Entity getEntityLinear(Entity entity) {
		return null;
	}

	public Trap getTrapRadial(Entity entity) {
		return null;
	}

	public Trap removeTrapLinear(Entity entity, int radius) {
		return null;
	}
}
