
package state.stateMachine;

import state.*;
import view.viewport.Viewport;
import view.window.GameWindow;

/**
 *
 * @author ChrisMoscoso
 */
public class RPGStateMachine extends StateMachine{
    private static RPGStateMachine RPGsm;
    private GameWindow window = new GameWindow();
    
    State menu, charSelect, petSelect, game, HUD;
    
    private RPGStateMachine(){
        menu = new MenuState();
        charSelect = new CharacterSelectionState();
        petSelect = new PetSelectionState();
        game = new GameState();
        HUD = new HUDState();
        
        this.add("menu", menu);
        this.add("charSelect", charSelect);
        this.add("petSelect", petSelect);
        this.add("game", game);
        this.add("HUD", HUD);
    }
    
     public void render() {
        if (!stateStack.isEmpty()) {
            State currentState = stateStack.peek();
            
            Viewport view = currentState.getViewport();
            window.displayState(currentState.getViewport());
            currentState.render();
        }
    }
    
    public void changeToMenuState() {
       this.changeToState("menu");
    }

    public void changetoHUDState(){this.changeToState("HUD");}

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
}
