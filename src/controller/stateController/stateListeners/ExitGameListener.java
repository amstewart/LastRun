
package controller.stateController.stateListeners;

import controller.stateController.StateController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ChrisMoscoso
 */
public class ExitGameListener implements ActionListener{

    StateController controller;
    
    public ExitGameListener(StateController c){
        controller = c;
    }

    public ExitGameListener() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        controller.exitGame();
    }
    
}
