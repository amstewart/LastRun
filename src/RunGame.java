
import model.gameEngine.GameEngine;
import state.stateMachine.RPGStateMachine;
import utility.Util;

public class RunGame {

    public static void main(String[] args) {
        Util.setDbgLevel(4); // Set debug

        RPGStateMachine s = RPGStateMachine.getInstance();
        s.changeToMenuState();
        GameEngine.getInstance().setRPGStateMachine(s);
        GameEngine.getInstance().start();
    }
}
