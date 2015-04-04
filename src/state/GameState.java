
package state;

import controller.stateController.StateController;
import model.GameBundle;
import state.stateMachine.RPGStateMachine;
import view.viewport.GameViewport;


/**
 *
 */
public class GameState extends RPGState {
    
    StateController controller;
    GameViewport gameViewport;

    public GameState(GameBundle bundle, RPGStateMachine s) {
        this.bundle = bundle;
        controller = new StateController(bundle, s);
        gameViewport = new GameViewport();
        viewport = gameViewport;
    }
    
    

    
    
    
}
