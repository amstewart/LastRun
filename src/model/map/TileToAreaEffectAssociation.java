/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import model.items.Item;

/**
 *
 * @author
 */
public class TileToAreaEffectAssociation extends TileAssociation{
		AreaEffect effect;
		Location location;
	
	public TileToAreaEffectAssociation(){

	}

	public void setAreaEffect(AreaEffect effect, Location location){
		this.effect=effect;
		this.location=location;
	}

	public AreaEffect getAreaEffect(){
		return effect;
	}

	public AreaEffect accept(TileToAreaEffectVisitor visitor){
		return effect;
	}

	public Item accept(TileToItemVisitor visitor){
		return null ;
	}


}
