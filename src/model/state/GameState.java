
package model.state;

import controller.GameController;
import view.viewport.GameViewport;
import view.viewport.Viewport;

/**
 *
 * @author ChrisMoscoso
 */
public class GameState implements iState{

    GameViewport view;
    GameController controller;
    
    public GameState(){
        view =  new GameViewport();
        controller = new GameController();
    }
    
    @Override
    public void update() {
        
    }

    @Override
    public void render() {
        view.render();
    }

    @Override
    public void onExit() {
        
    }

    @Override
    public void onEnter() {
        
    }

    @Override
    public Viewport getViewport() {
        return null;
    }
    
}
