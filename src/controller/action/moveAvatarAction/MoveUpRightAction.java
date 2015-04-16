package controller.action.moveAvatarAction;

import controller.action.Action;
import java.util.ArrayList;
import model.Vector2;
import model.map.GameMap;
import model.terrain.Terrain;
import utility.Util;

/**
 *
 * @author ChrisMoscoso
 */
public class MoveUpRightAction extends Action {

    private GameMap map;
    
    public MoveUpRightAction(){
        Util.dbgOut("Dont forget to set the map for the action.", 3);
    }
    
    public MoveUpRightAction(GameMap m){
        map = m;
    }
    
    public void setMap(GameMap m){
        map = m;
    }

    @Override
    public void perform() {
        Vector2 sourceLocation = map.getAvatarMovement().getPosition();
        Vector2 destLocation = map.getTileToTheNorthEast(sourceLocation).getLocation();
        
        ArrayList<Terrain.TerrainType> avatarsAllowableTerrainTypes = map.getAvatarMovement().getEntity().getTerrainTypesAllowedToMoveOn();
        Terrain.TerrainType destTerrain = map.getTile(destLocation).getTerrain().getTerrainType();
        
        if(avatarsAllowableTerrainTypes.contains(destTerrain)){
            map.moveAvatarTo(destLocation);
        }else{
            
        }
    }
}
