/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.stat;

import java.util.ArrayList;
import model.enums.StatsCategory;
import view.viewport.DialogueViewport;
import view.viewport.StatsViewport;
public class Stats {
	private int livesLeft;
	private int strength;
	private int agility;
	private int intellect;
	private int hardiness;
	private int experience;
	private int movement;

	private int equippedArmor;
	private int equippedWeapon;

	private int level;
	private int life;
	private int mana;
	private int offensiveRating;
	private int defensiveRating;
	private int armorRating;

	private ArrayList<StatsViewport> registeredViews = new ArrayList<>();
        private ArrayList<StatsCategory> statsCategory = new ArrayList<>();

	public void registerView(StatsViewport view) {
		registeredViews.add(view);
		notifyViews();
	}

	private void notifyViews() {
		for (StatsViewport views : registeredViews) {
			views.receive(this.getStats(), statsCategory );
		}
	}

	private ArrayList<Integer> getStats() {
            
		ArrayList<Integer> stats = new ArrayList<>();
		
		stats.add(strength); statsCategory.add(StatsCategory.STRENGTH);
		stats.add(agility); statsCategory.add(StatsCategory.AGILITY);
		stats.add(intellect); statsCategory.add(StatsCategory.INTELLECT);
		stats.add(hardiness); statsCategory.add(StatsCategory.HARDINESS);
		stats.add(experience); statsCategory.add(StatsCategory.EXPERIENCE);
		stats.add(movement); statsCategory.add(StatsCategory.MOVEMENT);
		stats.add(equippedArmor); statsCategory.add(StatsCategory.EQUIPPED_ARMOR);
		stats.add(equippedWeapon); statsCategory.add(StatsCategory.EQUIPPED_WEAPON);
		stats.add(level); statsCategory.add(StatsCategory.LEVEL);
		stats.add(offensiveRating); statsCategory.add(StatsCategory.OFFENSIVE_RATING);
		stats.add(defensiveRating); statsCategory.add(StatsCategory.DEFENSIVE_RATING);
		stats.add(armorRating); statsCategory.add(StatsCategory.ARMOR_RATING);
                stats.add(livesLeft); statsCategory.add(StatsCategory.LIVES_LEFT);
                stats.add(life); statsCategory.add(StatsCategory.LIFE);
		stats.add(mana); statsCategory.add(StatsCategory.MANA);
		return stats;
	}
        
        
	


	public Stats(int livesLeft, int strength, int agility, int intellect,
			int hardiness, int experience, int movement, int equippedArmor,
			int equippedWeapon) {
		super();
		setStatsInit(livesLeft, strength, agility, intellect, hardiness,
				experience, movement, equippedArmor, equippedWeapon);
	}

	public void mergeStats(Stats stat) {

		this.livesLeft += stat.getLivesLeft();
		this.strength += stat.getStrength();
		this.agility += stat.getAgility();
		this.intellect += stat.getIntellect();
		this.hardiness += stat.getHardiness();
		this.experience += stat.getExperience();
		this.movement += stat.getMovement();
		this.equippedArmor += stat.getEquippedArmor();
		this.equippedWeapon += stat.getEquippedWeapon();

		deriveStats();
	}
	
	private void setStatsInit(int livesLeft, int strength, int agility,
			int intellect, int hardiness, int experience, int movement,
			int equippedArmor, int equippedWeapon) {
		this.livesLeft = livesLeft;
		this.strength = strength;
		this.agility = agility;
		this.intellect = intellect;
		this.hardiness = hardiness;
		this.experience = experience;
		this.movement = movement;
		this.equippedArmor = equippedArmor;
		this.equippedWeapon = equippedWeapon;
	}
	
	public void setStats(Stats stat){
		this.livesLeft = stat.livesLeft;
		this.strength = stat.strength;
		this.agility = stat.agility;
		this.intellect = stat.intellect;
		this.hardiness = stat.hardiness;
		this.experience = stat.experience;
		this.movement = stat.movement;
		this.equippedArmor = stat.equippedArmor;
		this.equippedWeapon = stat.equippedWeapon;
		deriveStats();
	}
	private void setStats(final int livesLeft, final int strength, final int agility,
			final int intellect, final int hardiness, final int experience, final int movement,
			final int equippedArmor, final int equippedWeapon) {
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

	public void unMergeStats(Stats stat) {
		this.livesLeft -= stat.getLivesLeft();
		this.strength -= stat.getStrength();
		this.agility -= stat.getAgility();
		this.intellect -= stat.getIntellect();
		this.hardiness -= stat.getHardiness();
		this.experience -= stat.getExperience();
		this.movement -= stat.getMovement();
		this.equippedArmor -= stat.getEquippedArmor();
		this.equippedWeapon -= stat.getEquippedWeapon();
		deriveStats();

	}

	public void multiplyStats(Stats stats, int m) {
		this.livesLeft = m * stats.getLivesLeft();
		this.strength = m * stats.getStrength();
		this.agility = m * stats.getAgility();
		this.intellect = m* stats.getIntellect();
		this.hardiness = m*stats.getHardiness();
		this.experience = m*stats.getExperience();
		this.movement = m*stats.getMovement();
		this.equippedArmor = m*stats.getEquippedArmor();
		this.equippedWeapon = m* stats.getEquippedWeapon();
		this.deriveStats();
	}

	public void setLivesLeft(int livesLeft) {
		this.livesLeft += livesLeft;
		deriveStats();
	}

	public void setLife(int life) {
		this.life += life;
		deriveStats();
	}

	public void setLevel(int level) {
		this.level += level;
		deriveStats();
	}

	public void setStrength(int strength) {
		this.strength += strength;
		deriveStats();
	}

	public void setAgility(int agility) {
		this.agility += agility;
		deriveStats();
	}

	public void setIntellect(int intellect) {
		this.intellect += intellect;
		deriveStats();
	}

	public void setHardiness(int hardiness) {
		this.hardiness += hardiness;
		deriveStats();
	}

	public void setExperience(int experience) {
		this.experience += experience;
		deriveStats();
	}

	public void setMovement(int movement) {
		this.movement += movement;
		deriveStats();
	}

	public void setEquippedArmor(int equippedArmor) {
		this.equippedArmor += equippedArmor;
		deriveStats();
	}

	public void setEquippedWeapon(int equippedWeapon) {
		this.equippedWeapon += equippedWeapon;
		deriveStats();
	}

	public void setMana(int mana) {
		this.mana += mana;
		notifyViews();
	}

	public void deriveStats() {
		this.level = experience/100 + 1;
		this.life = hardiness * level;
		this.mana = intellect * level;
		this.offensiveRating = (equippedWeapon + strength)*level;
		this.defensiveRating = (agility)*level;
		this.armorRating = (equippedArmor + hardiness);
		notifyViews();
		if(this.life <= 0){
			this.kill();
		}
	}

	private void kill() {
		this.livesLeft--;
		if(this.livesLeft <= 0){
			this.die();
			return;
		}else{
			this.hardiness = 10;
		}
		deriveStats();
		notifyViews();
	}
	private void die() {
		//DialogueViewport.getInstance().print("You died. You are now a zombie.");
		notifyViews();
	}

	public int getLivesLeft() {
		return livesLeft;
	}

	public int getStrength() {
		return strength;
	}

	public int getAgility() {
		return agility;
	}

	public int getIntellect() {
		return intellect;
	}

	public int getHardiness() {
		return hardiness;
	}

	public int getExperience() {
		return experience;
	}

	public int getMovement() {
		return movement;
	}

	public int getEquippedArmor() {
		return equippedArmor;
	}

	public int getEquippedWeapon() {
		return equippedWeapon;
	}

	public int getLevel() {
		return level;
	}

	public int getLife() {
		return life;
	}

	public int getMana() {
		return mana;
	}

	public int getOffensiveRating() {
		return offensiveRating;
	}

	public int getDefensiveRating() {
		return defensiveRating;
	}

	public int getArmorRating() {
		return armorRating;
	}
}
