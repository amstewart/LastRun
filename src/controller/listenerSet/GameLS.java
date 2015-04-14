package controller.listenerSet;

import model.action.Action;
import model.item.TakeableItem;
import view.viewport.InventoryViewport;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


/**
 * Created by TubbyLumpkins on 4/13/15.
 */
public class GameLS extends ListenerSet {

    Drop drop;
    MoveUp mu;
    MoveDown md;
    MoveLU mlu;
    MoveLD mld;
    MoveRU mru;
    MoveRD mrd;

    public GameLS(ArrayList<Action> a){
        mu = new MoveUp(a.get(0));
        md = new MoveDown(a.get(1));
        mlu = new MoveLU((a.get(2)));
        mld = new MoveLD(a.get(3));
        mru = new MoveRU(a.get(4));
        mrd = new MoveRD(a.get(5));
        drop = new Drop(a.get(6));

    }

    //~~~~~~~~~~~~~~~~~~~~ Listeners ~~~~~~~~~~~~~~~~~~~~

    private class Drop implements ActionListener {
        Action axion;

        public Drop(Action a){
            this.axion = a;
            a.setActionListener(drop);          // link action with listener
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            TakeableItem ti = (TakeableItem) ((InventoryViewport.ItemButton) e.getSource() ).getItem();

            //axion.perform(ti);
        }
    }

    private class MoveUp implements KeyListener {
        Action axion;

        public MoveUp(Action a){
            this.axion = a;
            a.setKeyListener(this);
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_W) {
                axion.perform();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private class MoveDown implements KeyListener {
        Action axion;

        public MoveDown(Action a){
            this.axion = a;
            a.setKeyListener(this);          // link action with listener
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_S) {
                axion.perform();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private class MoveLU implements KeyListener {
        Action axion;

        public MoveLU(Action a){
            this.axion = a;
            a.setKeyListener(this);          // link action with listener
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_Q) {
                axion.perform();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
    private class MoveLD implements KeyListener {
        Action axion;

        public MoveLD(Action a){
            this.axion = a;
            a.setKeyListener(this);          // link action with listener
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_A) {
                axion.perform();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private class MoveRU implements KeyListener {
        Action axion;

        public MoveRU(Action a){
            this.axion = a;
            a.setKeyListener(this);          // link action with listener
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_E) {
                axion.perform();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private class MoveRD implements KeyListener {
        Action axion;

        public MoveRD(Action a){
            this.axion = a;
            a.setKeyListener(this);          // link action with listener
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_D) {
                axion.perform();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

}
