/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.terrain;

import model.Vector2;

import java.awt.Color;

/**
 *
 * @author
 */
public class WaterTerrain extends Terrain {
    
    public WaterTerrain(String id) {
    	super(id);
        this.terrainType = TerrainType.Water;
    }
    

    private int shadeOfBlue = (int) (Math.random() * 250 + 50);
    
 
    public void accept(TerrainVisitor visitor){
            visitor.visit(this);
    }

    @Override
    public Color getColor() {
        if(shadeOfBlue > 255) shadeOfBlue = 255;
        return new Color(0, 0, shadeOfBlue);
    }
    
    public String toString(){
        return "water";
    }
}
