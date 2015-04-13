package controller.listenerSet;

import model.action.Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by TubbyLumpkins on 4/11/15.
 */
public class HUDLS extends ListenerSet {


    Drop drop;
    Equip eq;
    Unequip uneq;

    public HUDLS(ArrayList<Action> a){
        eq = new Equip(a.get(0));
        drop = new Drop(a.get(1));
        uneq = new Unequip(a.get(2));
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Listeners~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private class Drop implements ActionListener {
        Action axion;

        public Drop(Action a){
            this.axion = a;
            a.setActionListener(drop);          // link action with listener
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            axion.perform();
        }
    }

    private class Equip implements ActionListener {

        Action axion;

        public Equip(Action a){
            this.axion = a;
            a.setActionListener(eq);          // link action with listener
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            axion.perform();
        }
    }

    private class Unequip implements ActionListener {

        Action axion;

        public Unequip(Action a){
            axion = a;                      // set things to perform
            a.setActionListener(uneq);      // link action with listener
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            axion.perform();
        }
    }
}
