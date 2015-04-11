package controller.listenerSet;

import model.action.Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by TubbyLumpkins on 4/7/15.
 */
public class CharacterSelectionLS extends ListenerSet{

    Back b;
    toPetSelection tps;
    TestKeyL tkl;

    public CharacterSelectionLS(ArrayList<Action> a){
        b = new Back(a.get(0));
        tps = new toPetSelection(a.get(1));
        tkl = new TestKeyL(a.get(2));
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Listeners~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private class Back implements ActionListener{

        Action axion;

        public Back(Action a){
            this.axion = a;
            a.setActionListener(this);          // link action with listener
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            axion.perform();
        }
    }

    private class toPetSelection implements  ActionListener{

        Action axion;

        public toPetSelection(Action a){
            this.axion = a;
            a.setActionListener(this);          // link action with listener
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            axion.perform();
        }
    }

    private class TestKeyL implements KeyListener {

        Action axion;

        public TestKeyL(Action a){
            this.axion = a;
            a.setKeyListener(this);          // link action with listener
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            axion.perform();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
