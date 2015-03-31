package main;

import model.state.GameState;
import model.state.MenuState;
import model.state.StateMachine;

/**
 *
 * @author ChrisMoscoso
 */
public class RunGame {

    public static void main(String[] args) {
        StateMachine s = new StateMachine();
        
        s.add("Menu", new MenuState());
        s.add("Game", new GameState());
        
        s.change("Menu");
        
        while(true){
            s.update();
            s.render();
            System.out.println(System.currentTimeMillis());
            try {
                Thread.sleep(33);
            } catch (InterruptedException ex) {}
        }
    }

}
