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
public class StillWater extends WaterTerrain {
    
    private int shadeOfBlue = (int) (Math.random() * 250 + 50);
    
    public void accept(TerrainVisitor visitor){
        //do whatever
    }

    @Override
    public Color getColor() {
        if(shadeOfBlue > 255) shadeOfBlue = 255;
        return new Color(0, 0, shadeOfBlue);
    }
}
