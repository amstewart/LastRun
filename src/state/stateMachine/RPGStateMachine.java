
package state.stateMachine;

import model.gameBundle.GameBundle;
import state.*;
import view.viewport.Viewport;
import view.window.GameWindow;

/**
 *
 * @author ChrisMoscoso
 */
public class RPGStateMachine extends StateMachine{
    private static RPGStateMachine RPGsm;
    private GameBundle gameBundle;
    private GameWindow window = new GameWindow();
    
    State menu, charSelect, petSelect, game, HUD;
    
    private RPGStateMachine(){
        gameBundle = new GameBundle();
        
        menu = new MenuState();
        charSelect = new CharacterSelectionState(gameBundle.getAvatar());
        game = new GameState(gameBundle.getMap(), gameBundle.getAvatar());
        
        this.add("menu", menu);
        this.add("charSelect", charSelect);
        this.add("petSelect", petSelect);
        this.add("game", game);
    }
    
     public void render() {
        if (!stateStack.isEmpty()) {
            State currentState = stateStack.peek();
            currentState.render();
        }
    }
    
    public void changeToMenuState() {
       this.changeToState("menu");
    }


    public void changeToGameState() {
        this.changeToState("game");
    }
    
    public void changeToCharSelectState(){
        this.changeToState("charSelect");
    }
    
    public void changeToPetSelectSate(){
        this.changeToState("petSelect");
    }
    
    public static RPGStateMachine getInstance(){
        if(RPGsm == null){
            RPGsm = new RPGStateMachine();
        }
        return RPGsm;
    }
    
    @Override
    public void pop(){
        super.pop();
        window.displayState(stateStack.peek().getViewport());
    }
    
    @Override
    protected void changeToState(String stateName){
        super.changeToState(stateName);
        window.displayState(stateStack.peek().getViewport());
    }
}
