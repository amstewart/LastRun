
package controller.keyControllers;

import controller.action.stateMachineAction.GoBackAction;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author ChrisMoscoso
 */
public class GeneralMenuController extends KeyController implements KeyListener{

    public GeneralMenuController(){
        actionSet.put(KeyEvent.VK_ESCAPE, new GoBackAction());
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        //System.out.println("CMON");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
