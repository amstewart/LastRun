package controller.action.moveAvatarAction;

import controller.action.Action;
import model.Vector2;
import model.map.GameMap;
import utility.Util;

/**
 *
 * @author ChrisMoscoso
 */
public class MoveUpAction extends Action {

    private GameMap map;
    
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
        Vector2 v2 = map.getAvatarMovement().getPosition();
        v2 = map.getTileToTheNorth(v2).getLocation();
        map.moveAvatarTo(v2);
    }
}
