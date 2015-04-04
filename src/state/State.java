/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import controller.Controller;
import controller.MenuController;
import model.GameBundle;
import view.viewport.MenuViewport;
import view.viewport.Viewport;

public interface State {

    void update();

    void render();

    void onEnter(GameBundle bundle);

    void onExit();

    Viewport getViewport();

}
