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
public class GrassTerrain extends Terrain {
	

    public GrassTerrain(String id) {
    	super(id);
        this.terrainType = TerrainType.Grass;
    }

    private int shadeOfGreen = (int) (Math.random() * 250 + 50);

    public void accept(TerrainVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Color getColor() {
        if (shadeOfGreen > 255) {
            shadeOfGreen = 255;
        }
        return new Color(0, shadeOfGreen, 0);
    }

    public String toString() {
        return "Grass";
    }

}
