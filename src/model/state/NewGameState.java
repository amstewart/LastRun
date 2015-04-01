
package model.state;

import controller.NewGameController;
import model.GameBundle;
import view.viewport.GameViewport;
import view.viewport.NewGameViewport;
import view.viewport.Viewport;

/**
 *
 * @author ChrisMoscoso
 */
public class NewGameState extends State{

    
    public NewGameState(GameBundle bundle, StateMachine stateMachine){
        viewPort =  new NewGameViewport();
        controller = new NewGameController(bundle, stateMachine, viewPort);
    }
    
    @Override
    public void update() {
        
       
    }

    @Override
    public void render() {
        viewPort.render();
    }

    @Override
    public void onExit() {
        
    }

    @Override
    public void onEnter() {
        
    }

    @Override
    public Viewport getViewport() {
        return viewPort;
    }
    
}
