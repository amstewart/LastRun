package model.terrain;

import java.awt.Color;

import model.Assetable;
import model.Vector2;

public abstract class Terrain implements Assetable{
		private String id;
		
		public Terrain(String id){
			setAssetID(id);
		}
    
        protected TerrainType terrainType ;
                
        public TerrainType getTerrainType(){
            return terrainType;
        }

	public abstract void accept(TerrainVisitor visitor);
	public abstract Color getColor();
	
	public String getAssetID(){
		return id;
	}
	
	public void setAssetID(String id){
		this.id=id;
	}
        
        public enum TerrainType{
            Water, Grass, Mountain
        }
}
