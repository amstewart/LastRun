package controller.listenerSet;

import state.Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by TubbyLumpkins on 4/7/15.
 */
public class CharacterSelectionLS extends ListenerSet{

    Back b;
    toPetSelection tps;

    public CharacterSelectionLS(ArrayList<Action> a){
        b = new Back(a.get(0));
        tps = new toPetSelection(a.get(1));
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
}
