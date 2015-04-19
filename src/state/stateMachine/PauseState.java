
package state.stateMachine;

import controller.keyControllers.PauseController;
import state.State;
import view.viewport.PauseViewport;

/**
 *
 * @author ChrisMoscoso
 */
public class PauseState extends State{

    
    
    public PauseState() {
        viewPort = new PauseViewport();
        controller = new PauseController();
    }

    @Override
    public void update() {
        
    }

    @Override
    public void onEnter() {
        
    }

    @Override
    public void onExit() {
        
    }
    
}
