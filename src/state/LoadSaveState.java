
package state;

import view.viewport.LoadSaveViewport;
import view.viewport.Viewport;

public class LoadSaveState extends State{

    private LoadSaveViewport viewPort;

    public LoadSaveState(){
        viewPort =  new LoadSaveViewport();
    }
    
    @Override
    public void update() {

    }

    @Override
    public void render() {
        viewPort.render();
    }

    @Override
    public void onEnter() {}

    @Override
    public void onExit() {
        
    }

    @Override
    public Viewport getViewport() {
        return viewPort;
    }
    
}
