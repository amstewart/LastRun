/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

/**
 *
 * @author
 */
public class Stats {
	int livesLeft;
	int strength;
	int agility;
	int intellect;
	int hardiness;
	int experience;
	int movement;
	
	int equippedArmor;
	int equippedWeapon;
	
	int level;
	int life;
	int mana;
	int offensiveRating;
	int defensiveRating;
	int armorRating;
	
	public Stats(int livesLeft, int strength, int agility, int intellect,
			int hardiness, int experience, int movement, int equippedArmor,
			int equippedWeapon) {
		super();
        setStats(livesLeft, strength, agility, intellect, hardiness, experience, movement, equippedArmor, equippedWeapon);
	}
	
	public void mergeStats(Stats stat){
		
		
		deriveStats();
	}

    private void setStats(int livesLeft, int strength, int agility, int intellect,
                          int hardiness, int experience, int movement, int equippedArmor,
                          int equippedWeapon) {
        this.livesLeft = livesLeft;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.hardiness = hardiness;
        this.experience = experience;
        this.movement = movement;
        this.equippedArmor = equippedArmor;
        this.equippedWeapon = equippedWeapon;
        deriveStats();
    }
	
	public void unMergeStats(Stats stat){
		
		
		deriveStats();
	}
	
	public void setLivesLeft(int livesLeft) {
		this.livesLeft = livesLeft;
		deriveStats();
	}

	public void setStrength(int strength) {
		this.strength = strength;
		deriveStats();
	}

	public void setAgility(int agility) {
		this.agility = agility;
		deriveStats();
	}

	public void setIntellect(int intellect) {
		this.intellect = intellect;
		deriveStats();
	}

	public void setHardiness(int hardiness) {
		this.hardiness = hardiness;
		deriveStats();
	}

	public void setExperience(int experience) {
		this.experience = experience;
		deriveStats();
	}

	public void setMovement(int movement) {
		this.movement = movement;
		deriveStats();
	}

	public void setEquippedArmor(int equippedArmor) {
		this.equippedArmor = equippedArmor;
		deriveStats();
	}

	public void setEquippedWeapon(int equippedWeapon) {
		this.equippedWeapon = equippedWeapon;
		deriveStats();
	}

	private void deriveStats(){
		
	}
	


    
}
