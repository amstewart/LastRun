package main;

import model.GameBundle;
import model.state.NewGameState;
import model.state.MenuState;
import model.state.StateMachine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

/**
 *
 * @author ChrisMoscoso
 */
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
