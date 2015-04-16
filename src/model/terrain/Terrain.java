package model.terrain;

import java.awt.Color;

public abstract class Terrain{ 
    
        protected TerrainType terrainType ;
                
        public TerrainType getTerrainType(){
            return terrainType;
        }

	public abstract void accept(TerrainVisitor visitor);
	public abstract Color getColor();
        
        public enum TerrainType{
            Water, Grass, Mountain
        }
}
