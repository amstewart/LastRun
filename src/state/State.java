/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import view.viewport.Viewport;

public abstract class State {

    protected Viewport viewPort;

    public abstract void update();

    public void render() {
        if (viewPort != null) {
            viewPort.render();
            viewPort.updateUI();
        }
    }

    public abstract void onEnter();

    public abstract void onExit();

    public Viewport getViewport() {
        return viewPort;
    }   
}
