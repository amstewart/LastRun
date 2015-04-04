
package state.stateMachine;

import model.GameBundle;
import state.CharSelectState;
import state.MenuState;
import state.GameState;

/**
 * This is our state machine that exists in the Application Domain.
 * 
 */
public class RPGStateMachine extends StateMachine{
    
    
    
    
    public RPGStateMachine(){
        super();
        bundle  = new GameBundle();
        
        this.add("Menu", new MenuState(bundle, this));
        this.add("CharSelect", new CharSelectState(bundle, this));
        this.add("Game", new GameState(bundle, this));

        this.changeToState("Menu", bundle);
    }

    public void changeToCharSelect(GameBundle bundle) {
        this.changeToState("CharSelect", bundle);
    }

    public void changeToMainMenu(GameBundle bundle) {
        this.changeToState("MainMenu", bundle);
    }
    
    public void changeToGame(GameBundle bundle){
        this.changeToState("Game", bundle);
    }
    
    

}