
package controller.stateController.stateListeners;

import controller.stateController.StateController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ChrisMoscoso
 */
public class MainMenuListener implements ActionListener{

    StateController controller;
    
    public MainMenuListener(StateController c){
        controller = c;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        controller.goToMainMenu();
    }
    
}
