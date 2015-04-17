/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.terrain;

import java.awt.Color;

/**
 *
 * @author
 */
public class MountainTerrain extends Terrain{
    
    public MountainTerrain(String id) {
    	super(id);
        this.terrainType = TerrainType.Mountain;
    }
    
    private int shadeOfRed = (int) (Math.random() * 250 + 50);

	public void accept(TerrainVisitor visitor){
		System.out.println("IM Mountain");
	}

    @Override
    public Color getColor() {
        if(shadeOfRed > 255) shadeOfRed = 255;
        return new Color(shadeOfRed, 0, 0);
    }
    
    public String toString(){
        return "mountain";
    }
}
