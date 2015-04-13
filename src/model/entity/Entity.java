package model.entity;

import model.item.TakeableItem;
import model.stat.Stats;
import model.Asset;
import model.Describable;
import java.util.LinkedList;
import model.enums.DefinedStats;
import model.item.CoinPouch;
import model.item.Inventory;

/**
 * Entities are all game objects which have the ability to move and manipulate
 * items on the map. Entities have simple skills which they can use, can
 * attack, and use other abilities. Entities all have a coin pouch which holds
 * their money.
 */
public abstract class Entity extends Asset implements Describable {
    // Fields
    private CoinPouch coins = new CoinPouch();
    private String name = "NONAME";
    private Stats stats;
    private Stats saving_stats = DefinedStats.ENTITYSTATS.getStats();
	private LinkedList<Status> statuses = new LinkedList<Status>();
	private Inventory inventory = new Inventory();

	public Entity(String asset_id) {
		super(asset_id);
		this.stats = saving_stats;
	}

    public void addStatus(Status status) {
        if (!statuses.contains(status))
            statuses.push(status);
    }

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

    public int getLivesLeft() {
		return stats.getLivesLeft();
	}

	public int getStrength() {
		return stats.getStrength();
	}

	public int getAgility() {
		return stats.getAgility();
	}

	public int getIntellect() {
		return stats.getIntellect();
	}

	public int getHardiness() {
		return stats.getHardiness();
	}

	public int getExperience() {
		return stats.getExperience();
	}

	public int getMovement() {
		return stats.getMovement();
	}

	public int getEquippedArmor() {
		return stats.getEquippedArmor();
	}

	public int getEquippedWeapon() {
		return stats.getEquippedWeapon();
	}

	public int getLevel() {
		return stats.getLevel();
	}

	public int getLife() {
		return stats.getLife();
	}

	public int getMana() {
		return stats.getMana();
	}

	public int getOffensiveRating() {
		return stats.getOffensiveRating();
	}

	public int getDefensiveRating() {
		return stats.getDefensiveRating();
	}

	public int getArmorRating() {
		return stats.getArmorRating();
	}

	public boolean addToInventory(TakeableItem item) {
		return inventory.addItem(item);
	}

	public TakeableItem[] getInventoryItems() {
		return inventory.getItems();
	}

	public Inventory getInventory() { return inventory; }
}
