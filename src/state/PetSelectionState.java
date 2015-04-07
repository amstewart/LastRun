
package state;

import view.viewport.PetSelectionViewport;
import view.viewport.Viewport;

public class PetSelectionState extends State{

    private PetSelectionViewport viewPort;

    public PetSelectionState(){
        viewPort = new PetSelectionViewport();
    }
    
    @Override
    public void update() {
        
    }

    @Override
    public void render() {
        viewPort.render();
    }

    @Override
    public void onEnter() {
    }

    @Override
    public void onExit() {
        
    }

    @Override
    public Viewport getViewport() {
        return viewPort;
    }
}
