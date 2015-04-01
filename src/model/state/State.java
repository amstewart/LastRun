/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.state;

import controller.Controller;
import controller.MenuController;
import model.GameBundle;
import view.viewport.MenuViewport;
import view.viewport.Viewport;

/**
 *
 * @author darien
 */
public abstract class State {
   
    protected Viewport viewPort;
    protected Controller controller;
    StateMachine stateMachine;
       
   
    public abstract void update();

    public abstract void render();

    public abstract void onExit();
    
    public abstract void onEnter();

    public abstract Viewport getViewport();
}
