package controller.action.moveAvatarAction;

import controller.action.Action;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import model.Vector2;
import model.map.GameMap;
import model.movement.EntityMovement;
import model.terrain.Terrain.TerrainType;
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

    @Override
    public void perform() {
        
        Vector2 sourceLocation = map.getAvatarMovement().getPosition();
        Vector2 destLocation = map.getTileToTheNorth(sourceLocation).getLocation();
        
        ArrayList<TerrainType> avatarsAllowableTerrainTypes = map.getAvatarMovement().getEntity().getTerrainTypesAllowedToMoveOn();
        TerrainType destTerrain = map.getTile(destLocation).getTerrain().getTerrainType();
        
        if(avatarsAllowableTerrainTypes.contains(destTerrain)){
            map.moveAvatarTo(destLocation);
        }else{
            MapViewport.drawCantMove(destLocation);
        }
        
    }    
}
