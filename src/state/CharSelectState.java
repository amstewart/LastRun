
package state;

import controller.stateController.StateController;
import controller.stateController.stateListeners.ExitGameListener;
import controller.stateController.stateListeners.GoBackListener;
import controller.stateController.stateListeners.NewGameListener;
import state.stateMachine.RPGStateMachine;
import model.GameBundle;
import view.viewport.CharSelectViewport;

/**
 *
 * 
 */
public class CharSelectState extends RPGState{
    
    StateController controller;
    CharSelectViewport charSelectViewport;


    public CharSelectState(GameBundle bundle, RPGStateMachine stateMachine) {
        this.controller = new StateController(bundle, stateMachine);
        charSelectViewport = new CharSelectViewport();
        this.viewport = charSelectViewport;
        
        charSelectViewport.setGoBackListener(new GoBackListener(controller));
    }
}
