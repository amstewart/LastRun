package controller.listenerSet;

import model.action.Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by TubbyLumpkins on 4/7/15.
 */
public class MenuLS extends ListenerSet {

    StartGame sg;
    ActionListener lg;
    ActionListener eg;

    public MenuLS(ArrayList<Action> a){
        eg = new ExitGame(a.get(0));
        lg = new LoadGame(a.get(1));
        sg = new StartGame(a.get(2));
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Listeners~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private class StartGame implements ActionListener{
        Action axion;

        public StartGame(Action a){
            this.axion = a;
            a.setActionListener(sg);          // link action with listener
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            axion.perform();
        }
    }

    private class LoadGame implements ActionListener {

        Action axion;

        public LoadGame(Action a){
            this.axion = a;
            a.setActionListener(this);          // link action with listener
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            axion.perform();
        }
    }

    private class ExitGame implements ActionListener {

        Action axion;

        public ExitGame(Action a){
            axion = a;                      // set things to perform
            a.setActionListener(this);      // link action with listener
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            axion.perform();
        }
    }
}
