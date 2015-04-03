package main;

import model.GameBundle;
import state.CharacterSelectionState;
import state.GameState;
import state.LoadSaveState;
import state.MenuState;
import state.PauseGameState;
import state.PetSelectionState;
import state.StateMachine;

public class RunGame {

    public static void main(String[] args) {



        GameBundle bundle = new GameBundle();
        StateMachine s = new StateMachine();
        s.add("menuState", new MenuState(bundle, s));
        s.add("characterSelectionState", new CharacterSelectionState(bundle, s));
        s.add("petSelectionState", new PetSelectionState(bundle,s));
        s.add("gameState", new GameState(bundle,s));
        s.add("pauseGameState", new PauseGameState(bundle,s));
        s.add("loadSaveState", new LoadSaveState(bundle,s));
        
        s.changeToState("menuState", bundle);
        
        while(true){
            s.update();
            s.render();
            //System.out.println(System.currentTimeMillis());
            try {
                Thread.sleep(33);
            } catch (InterruptedException ex) {}
        }

    }

}
