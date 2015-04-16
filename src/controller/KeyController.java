
package controller;

import controller.action.Action2;
import controller.action.moveAvatarAction.MoveDownAction;
import controller.action.moveAvatarAction.MoveDownLeftAction;
import controller.action.moveAvatarAction.MoveDownRightAction;
import controller.action.moveAvatarAction.MoveUpAction;
import controller.action.moveAvatarAction.MoveUpLeftAction;
import controller.action.moveAvatarAction.MoveUpRightAction;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import model.map.GameMap;

/**
 *
 * @author ChrisMoscoso
 */
public class KeyController implements KeyListener{
    
    Map<Integer, Action2> actionSet;

    public KeyController(GameMap map){
        actionSet = new HashMap();
        
        actionSet.put(KeyEvent.VK_W, new MoveUpAction(map));
        actionSet.put(KeyEvent.VK_E, new MoveUpRightAction(map));
        actionSet.put(KeyEvent.VK_Q, new MoveUpLeftAction(map));
        actionSet.put(KeyEvent.VK_A, new MoveDownLeftAction(map));
        actionSet.put(KeyEvent.VK_S, new MoveDownAction(map));
        actionSet.put(KeyEvent.VK_D, new MoveDownRightAction(map));
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        for(Integer keyCode : actionSet.keySet()){
            if(e.getKeyCode() == keyCode){
                actionSet.get(keyCode).perform();
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
