/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.listenerSet.CharacterSelectionLS;
import controller.listenerSet.ListenerSet;
import controller.listenerSet.MenuLS;
import state.Action;

import java.util.ArrayList;

public class Controller {

    private ListenerSet MenuStateSet;
    private ListenerSet CharacterSelectionSet;

    public void setMenuKLS(ArrayList<Action> a){
        MenuStateSet = new MenuLS(a);
    }

    public void setCharacterSelectionSet(ArrayList<Action> a){
        CharacterSelectionSet = new CharacterSelectionLS(a);
    }

}
