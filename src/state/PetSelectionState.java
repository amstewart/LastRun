
package state;

import controller.MenuController;
import controller.PetSelectionController;
import model.entity.GameBundle;
import view.viewport.PetSelectionViewport;
import view.viewport.Viewport;

public class PetSelectionState implements State{

    private PetSelectionViewport viewPort;
    private PetSelectionController controller;

    public PetSelectionState(GameBundle bundle, StateMachine stateMachine){
        viewPort = new PetSelectionViewport();
        controller = new PetSelectionController(bundle, stateMachine, viewPort);
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
