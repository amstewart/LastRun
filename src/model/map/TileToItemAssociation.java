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
public class TileToItemAssociation extends TileAssociation{
	Item item;
	Location location;

	public TileToItemAssociation(){

	}

	public void setItem(Item item, Location location){
		this.item=item;
		this.location=location;
	}

	public Item getItem(){
		return item;
	}

	public Item accept(TileToItemVisitor visitor){
		return item;
	}


	public AreaEffect accept(TileToAreaEffectVisitor visitor){
		return null ;
	}

}
