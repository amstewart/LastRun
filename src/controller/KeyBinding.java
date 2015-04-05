package controller;

import java.awt.event.KeyEvent;
import java.util.HashMap;

public class KeyBinding {
	private static HashMap<Integer,Command> controls;
	
	public KeyBinding(){
		controls = new HashMap<>();
		controls.put(KeyEvent.VK_W, Command.NORTH);
		controls.put(KeyEvent.VK_X, Command.SOUTH);
	}
	
	public void bind(int key,Command command){
		controls.put(key, command);
	}
	
	public static Command get(int key){
		return controls.get(key);
	}

}
