package model.enums;

import model.entity.Stats;

public enum DefinedStats {
	//
	MINUSHEALTH(new Stats(0,-10,0,0,0,0,0,0,0)),
	ADDHEALTH(new Stats(0,10,0,0,0,0,0,0,0)),
	ENTITYSTATS(new Stats(10,10,10,10,10,10,10,10,10));
	
	
	Stats stat;
	DefinedStats(Stats stat){
		this.stat = stat;
	}
	
	public Stats getStats(){
		return this.stat;
	}

}
