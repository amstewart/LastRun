package main;

import controller.KeyBinding;
import state.stateMachine.RPGStateMachine;
import utility.Util;

public class RunGame {

    public static void main(String[] args) {
        Util.setDbgLevel(6); // Set debug to maximum verbosity

        KeyBinding keyBinding = new KeyBinding();
        RPGStateMachine s = new RPGStateMachine();
        s.changeToMenuState();

        while(true){
            s.update();
            s.render();
            try {
                Thread.sleep(33);
            } catch (InterruptedException ex) {}
        }

    }

}
