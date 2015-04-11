/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.terrain;

/**
 *
 * @author
 */
public class TerrainVisitor{
	

	public void visit(Terrain terrain){
		terrain.accept(this);
	}

	


}
