
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
public class NewGameState implements iState{

    NewGameViewport view;
    NewGameController controller;
    
    public NewGameState(GameBundle bundle, StateMachine stateMachine){
        view =  new NewGameViewport();
        controller = new NewGameController(bundle, stateMachine, view);
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
        return view;
    }
    
}
