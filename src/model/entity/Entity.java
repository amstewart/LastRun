/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;
import model.Describable;

import java.util.LinkedList;

import model.enums.DefinedStats;
import model.item.CoinPouch;
import model.item.Inventory;


public class Entity {
	CoinPouch coinPouch;
	Status status;
    // Fields
    private String name = "NONAME";
    private Stats stats;
    private Stats saving_stats = DefinedStats.ENTITYSTATS.getStats();
	private LinkedList<Status> statuses = new LinkedList<>();
	private Inventory inventory = new Inventory();

	public Entity() {
		super();
		this.stats = saving_stats;
	}
	public void mergeStats(Stats stat) {
		stats.mergeStats(stat);
	}
	public void unMergeStats(Stats stat) {
		stats.unMergeStats(stat);
	}
	public void setLivesLeft(int livesLeft) {
		stats.setLivesLeft(livesLeft);
	}

	public void setStrength(int strength) {
		stats.setStrength(strength);
	}

	public void setAgility(int agility) {
		stats.setAgility(agility);
	}

	public void setIntellect(int intellect) {
		stats.setIntellect(intellect);
	}

	public void setHardiness(int hardiness) {
		stats.setHardiness(hardiness);
	}

	public void setExperience(int experience) {
		stats.setExperience(experience);
	}

	public void setMovement(int movement) {
		stats.setMovement(movement);
	}

	public void setEquippedArmor(int equippedArmor) {
		stats.setEquippedArmor(equippedArmor);
	}

	public void setEquippedWeapon(int equippedWeapon) {
		stats.setEquippedWeapon(equippedWeapon);
	}
	
    public void addStatus(Status status) {
        if (!statuses.contains(status))
            statuses.push(status);
    }


	public Inventory getInventory() {
		return inventory;
	}
}
