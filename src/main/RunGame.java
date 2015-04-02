package main;

import model.GameBundle;
import state.NewGameState;
import state.MenuState;
import state.StateMachine;

public class RunGame {

    public static void main(String[] args) {



        GameBundle bundle = new GameBundle();
        StateMachine s = new StateMachine();
        s.add("menuState", new MenuState(bundle, s));
        s.add("newGameState", new NewGameState(bundle, s));

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
