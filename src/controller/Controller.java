/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.listenerSet.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import model.action.Action;

public class Controller {

    private ListenerSet MenuStateSet;
    private ListenerSet CharacterSelectionSet;
    private ListenerSet HUDLS;
    private ListenerSet GameLS;

    public void setMenuLS(ArrayList<Action> a){
        MenuStateSet = new MenuLS(a);
    }

    public void setCharacterSelectionSet(ArrayList<Action> a){
        CharacterSelectionSet = new CharacterSelectionLS(a);
    }

    public void setHUDSelectionSet(ArrayList<Action> a){ HUDLS = new HUDLS(a); }

    public void setGameSet(ArrayList<Action> a){GameLS = new GameLS(a);}
    
    

}
