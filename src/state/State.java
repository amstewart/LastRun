/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import controller.Controller;
import view.viewport.Viewport;

public abstract class State {

    public abstract void update();
    public abstract void render();
    public abstract void onEnter();
    public abstract void onExit();
    public abstract Viewport getViewport();

    private Controller c = new Controller();

    public Controller getController(){
        return this.c;
    }
}
