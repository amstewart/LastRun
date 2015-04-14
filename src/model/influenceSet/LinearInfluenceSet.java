/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.influenceSet;

/**
 *
 * @author
 */
import java.util.ArrayList;
import java.util.Collection;
import model.map.GameMap;
import model.tile.Tile;


public class LinearInfluenceSet extends InfluenceSet {
	
	public LinearInfluenceSet(GameMap map, Tile source, int radius, int direction) {
		setMap(map);
		setSource(source);
		setRadius(radius);
		setDirection(direction);
	}

	@Override
	public Collection<InfluenceTile> getInfluenceSet() {
            ArrayList<InfluenceTile> list = new ArrayList<InfluenceTile>();
		return list;
	}
	

}
