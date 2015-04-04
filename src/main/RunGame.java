package main;

import state.stateMachine.RPGStateMachine;

public class RunGame {

    public static void main(String[] args) {



        RPGStateMachine s = new RPGStateMachine();
        
        
        while(true){
            s.update();
            s.render();
            try {
                Thread.sleep(33);
            } catch (InterruptedException ex) {}
        }

    }

}
