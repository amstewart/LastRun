/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

/**
 *
 * @author
 */
import java.util.*;

import model.item.Item;

public class Tile{
	private TerrainVisitor visitor;
	private TileToItemVisitor visitor1;
	private TileToAreaEffectVisitor visitor2;
	private ArrayList<TileAssociation> tileAssociation;
	private Location location;
	private Terrain terrain;
        private TileStatus status;
        
	

	public Tile(Terrain terrain,Location location){
		visitor= new TerrainVisitor();
		visitor1= new TileToItemVisitor();
		visitor2= new TileToAreaEffectVisitor();
		this.terrain=terrain;
		this.location=location;
		tileAssociation= new ArrayList<TileAssociation>();
	}

	public void visit(){
		visitor.visit(this.terrain);
	}



	public void setItem(Item item){
		TileToItemAssociation itemTile= new TileToItemAssociation();
		itemTile.setItem(item,location);

		tileAssociation.add(itemTile);
	}


	public Item getItem(){
		for(TileAssociation association: tileAssociation){
			if(association.accept(visitor1)!=null){
				return association.accept(visitor1);
			}
		}
		return null;
	}

	


	public void setAreaEffect(AreaEffect effect){
		TileToAreaEffectAssociation effectTile= new TileToAreaEffectAssociation();
		effectTile.setAreaEffect(effect,location);
		tileAssociation.add(effectTile);
	}


	public AreaEffect getAreaEffect(){
		for(TileAssociation association: tileAssociation){
			if(association.accept(visitor2)!=null){
				return association.accept(visitor2);
			}
		}
		return null;
	}
        
        public void setStatus(TileStatus status){
            this.status=status;
        }
        
        public void accept(MovementHandler movementHandler){
            status.accept(movementHandler);
        }
        
    



/* make methods that can remove the item from the tile of taken */



}
