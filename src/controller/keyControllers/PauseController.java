
package controller.keyControllers;

import controller.action.stateMachineAction.GoBackAction;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author ChrisMoscoso
 */
public class PauseController extends KeyController implements KeyListener{

    public PauseController(){
        actionSet.put(KeyEvent.VK_ESCAPE, new GoBackAction());
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
