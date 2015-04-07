/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import model.map.GameMap;
import model.map.Location;
import model.map.Tile;

/**
 *
 * @author
 */
public class TileTest {
    public static void main(String[] args){
        GameMap map= new GameMap();
	Tile t= map.getTile(new Location(0,0,0));
	t.getAreaEffect().print();
        //System.out.println("Im an areaEffect");
    }
}
