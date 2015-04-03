/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.GameBundle;
import state.StateMachine;

/*
 * Abstract controller because all controllers work
 * with the same state machine and game bundle
 */

public abstract class Controller {
    
    private GameBundle bundle;
    private StateMachine stateMachine;
    
    public Controller(GameBundle bundle, StateMachine stateMachine){
        this.stateMachine = stateMachine;
        this.bundle = bundle;
    }
    //TODO: add a listener for the pause button since most states can pause
    protected ActionListener goToMainMenu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                stateMachine.changeToState("menuState", bundle);
        }
    };

    public void updateBundle(GameBundle bundle) {
        this.bundle = bundle;
    }

    protected GameBundle getBundle() { return bundle; }

    protected StateMachine getStateMachine() { return stateMachine; }
}
