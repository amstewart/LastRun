
package model.state;

import view.viewport.Viewport;

/**
 *
 * @author ChrisMoscoso
 */
public interface iState {
    public void update();
    
    public void render();
    
    public void onExit();
    
    public void onEnter();
    
    public Viewport getViewport();
}
