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
public class TileToAreaEffectVisitor{


	public void visit(TileToAreaEffectAssociation association){
		association.accept(this);
	}

}
