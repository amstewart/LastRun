/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.influenceSet;

import model.tile.Tile;

/**
 *
 * @author
 */

public class InfluenceTile extends Tile {

	protected Tile tile;
	protected int radius;
	
	public InfluenceTile(Tile tile, int radius) {
		super(tile);
		this.tile = tile;
		this.radius = radius;
	}
	
	public InfluenceTile(Tile tile) {
		super(tile);
		this.tile = tile;
		this.radius = 0;
	}
	
	public Tile getTile() { return tile; }
	public int getRadius() { return radius; }
	public void setTile(Tile tile) { this.tile = tile; }
	public void setRadius(int radius) { this.radius = radius; }

}

