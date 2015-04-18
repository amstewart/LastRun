/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.terrain;

import model.Vector2;

/**
 *
 * @author
 */
public interface TerrainVisitor{

	public void visit(GrassTerrain terr_grass);

	public void visit(MountainTerrain terr_mount);

	public void visit(WaterTerrain terr_water);
}
