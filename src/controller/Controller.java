/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.GameBundle;
import model.state.MenuState;
import model.state.NewGameState;
import model.state.StateMachine;
import view.viewport.Viewport;

/**
 *
 * @author darien
 */
public abstract class Controller {
    
    protected GameBundle bundle;
    protected Viewport viewPort;
    protected StateMachine stateMachine;
    
    Controller(GameBundle bundle, StateMachine stateMachine, Viewport viewPort){
        
        this.stateMachine = stateMachine;
        this.bundle = bundle;
        this.viewPort = viewPort;
    }
    
    
    protected ActionListener goToMainMenu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                stateMachine.setCurrentState( new MenuState(bundle,stateMachine));
        }
    };
   
}
