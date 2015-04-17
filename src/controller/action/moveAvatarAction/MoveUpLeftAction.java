package controller.action.moveAvatarAction;

import controller.action.Action;

import java.util.ArrayList;

import model.Vector2;
import model.entity.Entity;
import model.map.GameMap;
import model.terrain.Terrain;
import model.tile.Tile;
import utility.ImageUtil;
import utility.Util;
import view.viewport.MapViewport;

/**
 *
 * @author ChrisMoscoso
 */
public class MoveUpLeftAction extends Action {

    private GameMap map;
    
    public MoveUpLeftAction(){
        Util.dbgOut("Dont forget to set the map for the action.", 3);
    }
    
    public MoveUpLeftAction(GameMap m){
        map = m;
    }
    
    public void setMap(GameMap m){
        map = m;
    }

    public boolean isAreaEffect(Tile tile){
    	if(tile.isAreaEffectOwner()){
    		return true;
    	}
    	return false;
    }
    
    public void updateEntityTileLocation(Entity e,Tile source, Tile dest){
    	source.removeEntity(e);
    	dest.addEntity(e);
    }
    
    public void applyAreaEffect(Entity e,Tile dest){
    	dest.getAreaEffect().apply(e);
    }

    @Override
    public void perform() {
        Vector2 sourceLocation = map.getAvatarMovement().getPosition();
        Vector2 destLocation = map.getTileToTheNorthWest(sourceLocation).getLocation();
        
        Tile source= map.getTile(sourceLocation);
        Tile dest= map.getTile(destLocation);
        
        ArrayList<Terrain.TerrainType> avatarsAllowableTerrainTypes = map.getAvatarMovement().getEntity().getTerrainTypesAllowedToMoveOn();
        Terrain.TerrainType destTerrain = map.getTile(destLocation).getTerrain().getTerrainType();
        
        if(avatarsAllowableTerrainTypes.contains(destTerrain)){
        	Entity e=source.getEntity();
        	map.moveAvatarTo(destLocation);
            map.changeAvatarSprite(ImageUtil.EN_SKEL_NW);
        	updateEntityTileLocation(e, source, dest);
            if(dest.isAreaEffectOwner()){
            	applyAreaEffect(e,dest);
            }
        }else{
            MapViewport.drawCantMove(destLocation);
        }
    }
}