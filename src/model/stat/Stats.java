/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.stat;

import java.util.ArrayList;

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

	public void registerView(StatsViewport view) {
		registeredViews.add(view);
		notifyViews();
	}

	private void notifyViews() {
		for (StatsViewport views : registeredViews) {
			views.receive(this.getStrings());
		}
	}

	private ArrayList<String> getStrings() {
		ArrayList<String> string = new ArrayList<>();
		string.add("Lives Left: " + Integer.toString(livesLeft));
		string.add("Strength: " +Integer.toString(strength));
		string.add("Agility: " +Integer.toString(agility));
		string.add("Intellect: " +Integer.toString(intellect));
		string.add("Hardiness: " +Integer.toString(hardiness));
		string.add("Experience: " +Integer.toString(experience));
		string.add("Movement: " +Integer.toString(movement));

		string.add("Equipped Armor: " +Integer.toString(equippedArmor));
		string.add("Equipped Weapon: " +Integer.toString(equippedWeapon));

		string.add("Level: " +Integer.toString(level));
		string.add("Life: " +Integer.toString(life));
		string.add("Mana: " +Integer.toString(mana));
		string.add("Offensive Rating: " +Integer.toString(offensiveRating));
		string.add("Defensive Rating: " +Integer.toString(defensiveRating));
		string.add("Armor Rating: " +Integer.toString(armorRating));
		return string;
	}
	
	public Stats(){
		
	}

	public Stats(int livesLeft, int strength, int agility, int intellect,
			int hardiness, int experience, int movement, int equippedArmor,
			int equippedWeapon) {
		super();
		setStats(livesLeft, strength, agility, intellect, hardiness,
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
	private void setStats(int livesLeft, int strength, int agility,
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
		this.livesLeft = livesLeft;
		deriveStats();
	}

	public void setLife(int life) {
		this.life = life;
		deriveStats();
	}

	public void setLevel(int level) {
		this.level = level;
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

	public void setMana(int mana) {
		this.mana = mana;
		notifyViews();
	}

	private void deriveStats() {
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
