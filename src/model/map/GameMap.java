/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import model.entity.Entity;
import model.tile.Tile;

/**
 *
 * @author
 */
public class GameMap{
	private Tile[][] map;
	private MapBuilder m;


	public GameMap(){
		m= new MapBuilder();
		map=m.getMap();
                
	}

        
        public void addEntity(Entity e, Location location){
            //getTile(location).setEntity(e);
        }
        
	public Tile getTile(Location location){
		return map[location.getX()][location.getY()];
	}

}
