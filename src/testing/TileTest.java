/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import model.Vector3;
import model.map.GameMap;
import model.tile.Tile;

/**
 *
 * @author
 */
public class TileTest {
    public static void main(String[] args){
        GameMap map= new GameMap();
	Tile t= map.getTile(Vector3.zero());

	//t.getAreaEffect();
    }
}
