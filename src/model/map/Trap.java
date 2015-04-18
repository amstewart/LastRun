package model.map;


import model.Assetable;
import model.entity.Entity;

public abstract class Trap implements Assetable {
	protected int detectionLevelRequired=1;
	protected boolean visible=false; //change this after
	protected int damage=1;
	protected boolean destroyed=false;
	private String id;
	
	public Trap(String id){
		setAssetID(id);
	}
	
	public abstract int getDamage();
	public abstract void apply(Entity e);
	public boolean isVisible(){return visible;}
	
	public int detectionRequired(){
		return detectionLevelRequired;
	}
	
	public void destroy(){
		damage=0;
		visible=false;
		destroyed=true;
	}
	
	public void makeVisible(){
		if(destroyed==false)
		visible=true;		
	}
	
	public String getAssetID(){
		return id;
	}
	
	public void setAssetID(String id){
		this.id=id;
	}
}
