import state.stateMachine.RPGStateMachine;
import utility.Util;

public class RunGame {

    public static void main(String[] args) {
        Util.setDbgLevel(6); // Set debug to maximum verbosity

        RPGStateMachine s = RPGStateMachine.getInstance();
        //s.changeToGameState();
        s.changeToMenuState();
        //s.changeToCharSelectState();
        while(true){
            s.update();
            s.render();
            try {
                Thread.sleep(33);
            } catch (InterruptedException ex) {}
        }

    }

}
