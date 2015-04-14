/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.influenceSet;

/**
 *
 * @author
 */
import java.util.Collection;
import model.map.GameMap;
import model.tile.Tile;

public abstract class InfluenceSet {
	protected GameMap map;
	protected Tile source;
	protected int radius;
	protected int direction;
	
	public abstract Collection<InfluenceTile> getInfluenceSet();
	
	
	public void setSource(Tile source) {
		this.source = source;
	}
	public  void setRadius(int radius) {
		this.radius = radius;
	}
	public  void setDirection(int direction) {
		this.direction = direction;
	}
	public  void setMap(GameMap map) {
		this.map = map;
	}
	public GameMap getMap() {
		return map;
	}
	public Tile getTile() {
		return source;
	}
	public int getRadius() {
		return radius;
	}
	public int getDirection() {
		return direction;
	}
	
	
	public void printInfluenceSet() {
		System.out.println("Printing Influence Set: ");
		for (InfluenceTile tile: getInfluenceSet()) {
			System.out.println(tile);
		}
		System.out.println("Done printing.");
		
	}
}

