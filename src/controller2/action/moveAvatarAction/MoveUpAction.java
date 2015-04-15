package controller2.action.moveAvatarAction;

import controller2.action.Action2;
import model.Vector3;
import model.map.GameMap;
import utility.Util;

/**
 *
 * @author ChrisMoscoso
 */
public class MoveUpAction extends Action2 {

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
        Vector3 v3 = map.getAvatarMovement().getPosition();
        v3 = map.getTileToTheNorth(v3).getLocation();
        map.moveAvatarTo(v3);
    }

}
