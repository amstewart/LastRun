package controller.action.moveAvatarAction;

import controller.action.Action;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import model.Vector2;
import model.entity.Entity;
import model.map.GameMap;
import model.movement.EntityMovement;
import model.terrain.Terrain;
import model.terrain.Terrain.TerrainType;
import model.tile.Tile;
import utility.ImageUtil;
import utility.Util;
import view.viewport.MapViewport;

/**
 *
 * @author ChrisMoscoso
 */
public class MoveUpAction extends Action{

    private GameMap map;
    private EntityMovement avatarMovement;
    
    public MoveUpAction(){
        Util.dbgOut("Dont forget to set the map for the action.", 3);
    }
    
    public MoveUpAction(GameMap m){
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
        Vector2 destLocation = map.getTileToTheNorth(sourceLocation).getLocation();
        
        Tile source= map.getTile(sourceLocation);
        Tile dest= map.getTile(destLocation);
        
        ArrayList<Terrain.TerrainType> avatarsAllowableTerrainTypes = map.getAvatarMovement().getEntity().getTerrainTypesAllowedToMoveOn();
        Terrain.TerrainType destTerrain = map.getTile(destLocation).getTerrain().getTerrainType();
        
        if(avatarsAllowableTerrainTypes.contains(destTerrain)){
        	Entity e=source.getEntity();
        	map.moveAvatarTo(destLocation);
            map.changeAvatarSprite(ImageUtil.EN_SKEL_N);
        	updateEntityTileLocation(e, source, dest);
            if(dest.isAreaEffectOwner()){
            	applyAreaEffect(e,dest);
            }
        }else{
            MapViewport.drawCantMove(destLocation);
        }
    }
}