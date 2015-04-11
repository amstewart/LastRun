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
public class GrassTerrain extends Terrain{
    
    private int shadeOfGreen = (int) (Math.random() * 250 + 50);
    
 
    public void accept(TerrainVisitor visitor){
            System.out.println("IM GRASS");
    }

    @Override
    public Color getColor() {
        if(shadeOfGreen > 255) shadeOfGreen = 255;
        return new Color(0, shadeOfGreen, 0);
    }

}
