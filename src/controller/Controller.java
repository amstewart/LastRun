/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.action.Action;
import controller.listenerSet.CharacterSelectionLS;
import controller.listenerSet.ListenerSet;
import controller.listenerSet.MenuLS;
import controller.listenerSet.HUDLS;

import java.util.ArrayList;

public class Controller {

    private ListenerSet MenuStateSet;
    private ListenerSet CharacterSelectionSet;
    private ListenerSet HUDLS;

    public void setMenuLS(ArrayList<Action> a){
        MenuStateSet = new MenuLS(a);
    }

    public void setCharacterSelectionSet(ArrayList<Action> a){
        CharacterSelectionSet = new CharacterSelectionLS(a);
    }

    public void setHUDSelectionSet(ArrayList<Action> a){ HUDLS = new HUDLS(a); }

}
