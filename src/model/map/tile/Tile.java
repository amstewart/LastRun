/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map.tile;

import model.map.terrain.Terrain;
import model.utils.Position;

/**
 *
 * @author
 */
public class Tile {
	
	Position position;
	TileStatus tileStatus;
	Terrain terrain;
	
	public Tile(Position position) {
		this.position = position;
	}
	

	public Position getPosition() {
		return position;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	
	
	
	
    
}
