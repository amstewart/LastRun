package model.gameEngine;

import java.util.ArrayList;
import java.util.Observable;
import model.observer.GameEngineObserver;
import state.stateMachine.RPGStateMachine;

/**
 * The game engine is responsible for updating the game and rendering it to the
 * screen. It runs on a threaded loop that updates approximately x frames per
 * second.
 *
 * TODO: Enforce engine to run at any FPS rate. It currently runs at 20 FPS.
 *
 * @author ChrisMoscoso
 */
public class GameEngine implements Runnable {

    private ArrayList<GameEngineObserver> observers = new ArrayList();
    private RPGStateMachine rpgStateMachine;
    private static GameEngine gameEngineInstance;
    private Thread thread;
    private static int FPS; //Right now the game enginer runs at an arbitrary 

    private GameEngine() {
        this(30);
    }

    /**
     * Specify how fast the game engine should run in Frames Per Second
     *
     * @param FramesPerSecond is how fast the game engine should tick
     */
    public GameEngine(int FramesPerSecond) {
        FPS = FramesPerSecond;
        thread = new Thread(this);
    }

    /**
     * Begins running the game engine
     */
    public void start() {
        thread.start();
    }

    /**
     * While the game engine runs, it continually a 2 step loop: update game,
     * draw game.
     */
    @Override
    public void run() {
        while (true) {
            updateGame();
            renderGame();
            notifyObserversGameEngineHasTicked();
            try {
                Thread.sleep(33);
            } catch (InterruptedException ex) {

            }
        }
    }

    /**
     * Update the game models
     */
    private void updateGame() {
        if(rpgStateMachine != null){
            rpgStateMachine.update();
        }
    }

    /**
     * Render the game to the screen
     */
    private void renderGame() {
        if(rpgStateMachine != null){
            rpgStateMachine.render();
        }
    }
    
    public void setRPGStateMachine(RPGStateMachine s){
        rpgStateMachine = s;
    }

    public static int getFPS() {
        return FPS;
    }

    public static GameEngine getInstance() {
        if (gameEngineInstance == null) {
            gameEngineInstance = new GameEngine();
        }
        return gameEngineInstance;
    }
    
    public void addObserver(GameEngineObserver o){
        observers.add(o);
    }
    
    public void removeObserver(GameEngineObserver o){
        observers.remove(o);
    }

    private void notifyObserversGameEngineHasTicked() {
        for(GameEngineObserver o :observers){
            o.gameEngineHasTicked();
        }
    }
    
    
}
