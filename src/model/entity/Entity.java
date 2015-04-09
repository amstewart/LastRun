/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;
import model.Assetable;
import model.Describable;
import java.util.LinkedList;

import model.enums.DefinedStats;
import model.item.CoinPouch;
import model.item.Inventory;

public abstract class Entity extends Assetable implements Describable {
    // Fields
    private CoinPouch coins = new CoinPouch();
    private String name = "NONAME";
    private Stats stats;
    private Stats saving_stats = DefinedStats.ENTITYSTATS.getStats();
	private LinkedList<Status> statuses = new LinkedList<>();
	private Inventory inventory = new Inventory();

	public Entity(String asset_id) {
		super(asset_id);
		this.stats = saving_stats;
	}

    public void addStatus(Status status) {
        if (!statuses.contains(status))
            statuses.push(status);
    }

    public Inventory getInventory() { return inventory; }

    @Override
    public String getName() {
        return this.name;
    }

	public void mergeStats(Stats stat) {
		stats.mergeStats(stat);
	}

	public void setAgility(int agility) {
		stats.setAgility(agility);
	}

	public void setEquippedArmor(int equippedArmor) {
		stats.setEquippedArmor(equippedArmor);
	}

	public void setEquippedWeapon(int equippedWeapon) {
		stats.setEquippedWeapon(equippedWeapon);
	}

    public void setExperience(int experience) {
        stats.setExperience(experience);
    }

    public void setHardiness(int hardiness) {
        stats.setHardiness(hardiness);
    }

    public void setIntellect(int intellect) {
        stats.setIntellect(intellect);
    }

    public void setLivesLeft(int livesLeft) {
        stats.setLivesLeft(livesLeft);
    }

    public void setMovement(int movement) {
        stats.setMovement(movement);
    }

    public void setStrength(int strength) {
        stats.setStrength(strength);
    }

    public void unMergeStats(Stats stat) {
        stats.unMergeStats(stat);
    }
}
