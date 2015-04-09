package main;

import controller.KeyBinding;
import state.MenuState;
import state.StateMachine;
import utility.Util;

public class RunGame {

    public static void main(String[] args) {
        Util.setDbgLevel(6);

   	KeyBinding keyBinding = new KeyBinding();
        StateMachine s = new StateMachine();
        s.add("menuState", new MenuState());
        //s.add("characterSelectionState", new CharacterSelectionState(bundle, s));
        //s.add("petSelectionState", new PetSelectionState(bundle,s));
        //s.add("gameState", new GameState(bundle,s));
        //s.add("pauseGameState", new PauseGameState(bundle,s));
        //s.add("loadSaveState", new LoadSaveState(bundle,s));
        
        s.changeToState("menuState");
        
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
