
package controller.keyControllers;

import controller.action.stateMachineAction.GoBackAction;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author ChrisMoscoso
 */
public class PauseController implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            new GoBackAction().perform();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
