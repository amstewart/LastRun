/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.ListenerSets.CharacterSelectionLS;
import controller.ListenerSets.ListenerSet;
import controller.ListenerSets.MenuLS;
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
