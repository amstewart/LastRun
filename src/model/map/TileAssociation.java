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
public abstract class TileAssociation{


	public abstract Item accept(TileToItemVisitor visitor);

	public abstract AreaEffect accept(TileToAreaEffectVisitor visitor);
	
}
