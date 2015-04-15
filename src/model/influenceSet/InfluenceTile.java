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
	protected int radius;
	
	public InfluenceTile(int radius) {
		super();
		this.radius = radius;
	}
	
	public InfluenceTile(Tile tile) {
		super();
		this.radius = 0;
	}

        
	public int getRadius() { return radius; }
	public void setRadius(int radius) { this.radius = radius; }

}

