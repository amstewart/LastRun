/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import controller.keyControllers.KeyController;
import view.viewport.Viewport;

public abstract class State {
    
    protected KeyController controller;

    protected Viewport viewPort;

    public abstract void update();

    public void render() {
        if (viewPort != null) {
            viewPort.render();
            viewPort.updateUI();
        }
    }

    public void onEnter(){
        render();
        viewPort.addKeyListener(controller);
    }

    public void onExit(){
        viewPort.removeKeyListener(controller);
    }

    public Viewport getViewport() {
        return viewPort;
    }   
}
