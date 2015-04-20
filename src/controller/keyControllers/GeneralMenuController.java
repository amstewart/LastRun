
package controller.keyControllers;

import controller.action.Action;
import controller.action.stateMachineAction.GoBackAction;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author ChrisMoscoso
 */
public class GeneralMenuController extends KeyController{

    
    
    public GeneralMenuController(Action a){
        actionSet.put(KeyEvent.VK_ESCAPE, a );
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
