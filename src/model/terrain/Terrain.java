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
public abstract class Terrain{ 

	public abstract void accept(TerrainVisitor visitor);
	public abstract Color getColor();
}
