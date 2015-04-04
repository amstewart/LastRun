package state;

import controller.stateController.StateController;
import model.GameBundle;
import view.viewport.Viewport;



/**
 *
 *
 */
public abstract class RPGState implements State{

    protected GameBundle bundle;
    protected Viewport viewport;
    
    @Override
    public void update() {
        
    }

    @Override
    public void render() {
        viewport.render();
    }

    @Override
    public void onExit() {
        
    }

    @Override
    public Viewport getViewport() {
        return viewport;
    }

    @Override
    public void onEnter(GameBundle bundle) {
        setBundle(bundle);
    }
   
    private void setBundle(GameBundle gb){
        this.bundle = gb;
    }
}
