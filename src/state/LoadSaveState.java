
package state;

import controller.LoadSaveController;
import model.entity.GameBundle;
import view.viewport.LoadSaveViewport;
import view.viewport.Viewport;

public class LoadSaveState implements State{

    private LoadSaveViewport viewPort;
    private LoadSaveController controller;

    public LoadSaveState(GameBundle bundle, StateMachine stateMachine){
        viewPort =  new LoadSaveViewport();
        controller = new LoadSaveController(bundle, stateMachine, viewPort);
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
