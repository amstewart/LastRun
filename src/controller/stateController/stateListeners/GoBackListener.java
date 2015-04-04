
package controller.stateController.stateListeners;

import controller.stateController.StateController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ChrisMoscoso
 */
public class GoBackListener implements ActionListener{
    
    StateController controller;
    
    public GoBackListener(StateController c){
        controller = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.goBack();
    }
    
}
