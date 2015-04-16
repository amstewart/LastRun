package view.viewport;

import java.util.ArrayList;

import model.action.Action;
import model.stat.Stats;

public class StatsViewport extends Viewport{
	
	public StatsViewport(Stats stats){
		stats.registerView(this);
	}
	
	public void receive(ArrayList<String> stats){
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setListeners(ArrayList<Action> a) {
		// TODO Auto-generated method stub
		
	}
	
	

}
