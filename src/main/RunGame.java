package main;

import model.GameBundle;
import model.state.NewGameState;
import model.state.MenuState;
import model.state.StateMachine;

/**
 *
 * @author ChrisMoscoso
 */
public class RunGame {

    public static void main(String[] args) {
        
        GameBundle bundle = new GameBundle();
        StateMachine s = new StateMachine();
        s.setCurrentState( new MenuState(bundle,s));
        
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
