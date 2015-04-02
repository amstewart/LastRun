
package state;

import controller.NewGameController;
import model.GameBundle;
import view.viewport.NewGameViewport;
import view.viewport.Viewport;

public class NewGameState implements State{

    private NewGameViewport viewPort;
    private NewGameController controller;

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
    public void onEnter(GameBundle bundle) {
        controller.updateBundle(bundle);
    }

    @Override
    public void onExit() {
        
    }

    @Override
    public Viewport getViewport() {
        return viewPort;
    }
    
}
