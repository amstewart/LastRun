package model.enums;

import model.stat.Stats;

public enum DefinedStats {
	//int livesLeft, int strength, int agility, int intellect,
	//int hardiness, int experience, int movement, int equippedArmor,
	//int equippedWeapon
	DEFAULTSTATS(new Stats(0, 0, 0, 0, 0, 0, 0, 0, 0)),
	SNEAKWEAPONSTATS1(new Stats(0, 0, 0, 0, 0, 0, 0, 0, 5)),
	SNEAKWEAPONSTATS2(new Stats(0, 0, 0, 0, 0, 0, 0, 0, 8)),
	SNEAKWEAPONSTATS3(new Stats(0, 0, 0, 0, 0, 0, 0, 0, 11)),
	SMASHERWEAPONSTATS1(new Stats(0, 0, 0, 0, 0, 0, 0, 0, 10)),
	SMASHERWEAPONSTATS2(new Stats(0, 0, 0, 0, 0, 0, 0, 0, 20)),
	SMASHERWEAPONSTATS3(new Stats(0, 0, 0, 0, 0, 0, 0, 0, 23)),
	SUMWEAPONSTATS1(new Stats(0, 0, 0, 10, 0, 0, 0, 0, 7)),
	SUMWEAPONSTATS2(new Stats(0, 0, 0, 15, 0, 0, 0, 0, 2)),
	SUMWEAPONSTATS3(new Stats(0, 0, 0, 25, 0, 0, 0, 0, 11)),
	MINUSHEALTH(new Stats(0,-10,0,0,0,0,0,0,0)),
	MINUSHARDINESS(new Stats(0,0,0,0,10,0,0,0,0)),
	MINUSINTELLECT(new Stats(0,0,0,10,0,0,0,0,0)),
	ADDHEALTH(new Stats(0,10,0,0,0,0,0,0,0)),
	ADDHARDINESS(new Stats(0,0,0,0,10,0,0,0,0)),
	ADDINTELLECT(new Stats(0,0,0,10,0,0,0,0,0)),
	ADDHEADARMOR(new Stats(0, 0, 0, 0, 0, 0, 0, 5, 0)),
	ADDCHESTARMOR(new Stats(0, 0, 0, 0, 0, 0, 0, 10, 0)),
	ADDLEGARMOR(new Stats(0, 0, -4, 0 ,0 ,0 ,0 ,0, 10)),
	ADDWEAPON(new Stats(0, 0, 0, 0, 0, 0, 0, 0, 10)),
	ENTITYSTATS(new Stats(10,10,10,10,10,10,10,10,10));

	Stats stat;

	DefinedStats(Stats stat){
		this.stat = stat;
	}
	
	public Stats getStats(){
		return new Stats(stat.getLivesLeft(), stat.getStrength(), stat.getAgility(), stat.getIntellect(), stat.getHardiness(),
				stat.getExperience(), stat.getMovement(), stat.getEquippedArmor(), stat.getEquippedWeapon());
	}

}
