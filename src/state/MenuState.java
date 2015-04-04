
package state;

import controller.MenuController;
import model.entity.GameBundle;
import view.viewport.MenuViewport;
import view.viewport.Viewport;

public class MenuState implements State{

    private MenuViewport viewPort;
    private MenuController controller;

    public MenuState(GameBundle bundle, StateMachine stateMachine){
        viewPort = new MenuViewport();
        controller = new MenuController(bundle, stateMachine, viewPort);
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
