/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.areaEffect;

import model.Assetable;
import model.entity.Entity;

public abstract class AreaEffect implements Assetable{

	private String id;
	
	public AreaEffect(){}
	
	public AreaEffect(String id){
		setAssetID(id);
	}
	
	public String getAssetID(){
		return id;
	}
	
	public void setAssetID(String id){
		this.id=id;
	}

	public abstract void apply(Entity e);
}
