package model.enums;

import model.stat.Stats;

public enum DefinedStats {
	//int livesLeft, int strength, int agility, int intellect,
	//int hardiness, int experience, int movement, int equippedArmor,
	//int equippedWeapon
	MINUSHEALTH(new Stats(0,-10,0,0,0,0,0,0,0)),
	ADDHEALTH(new Stats(0,10,0,0,0,0,0,0,0)),
	ADDHARDINESS(new Stats(0,0,0,0,10,0,0,0,0)),
	ADDINTELLECT(new Stats(0,0,0,10,0,0,0,0,0)),
	ADDARMOR(new Stats(0, 0, 0, 0, 0, 0, 0, 5, 0)),
	ADDWEAPON(new Stats(0, 0, 0, 0, 0, 0, 0, 0, 10)),
	ENTITYSTATS(new Stats(10,10,10,10,10,10,10,10,10));
	
	
	Stats stat;
	DefinedStats(Stats stat){
		this.stat = stat;
	}
	
	public Stats getStats(){
		return this.stat;
	}

}
