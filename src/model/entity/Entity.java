package model.entity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import model.entity.npc.pet.Pet;
import model.item.*;
import model.owner.EntityOwner;
import model.stat.Stats;
import model.Assetable;
import model.Describable;

import java.util.LinkedList;

import Visitor.EntityVisitor;
import Visitor.VisitorContainer;
import model.enums.DefinedStats;
import model.terrain.Terrain.TerrainType;

/**
 * Entities are all game objects which have the ability to move and manipulate
 * items on the map. Entities have simple skills which they can use, can
 * attack, and use other abilities. Entities all have a coin pouch which holds
 * their money.
 */
public abstract class Entity implements Describable, Assetable{
    // Fields
    private ArrayList<TerrainType> terrainTypesAllowedToMoveOn = new ArrayList();

	private Inventory inventory = new Inventory();
	private String id;
	private EntityOwner pets = new EntityOwner();
    private String name = "NONAME";
    private Stats stats;
    private Stats saving_stats = DefinedStats.ENTITYSTATS.getStats();
	private LinkedList<Status> statuses = new LinkedList<Status>();


	public Entity() {
		this.stats = saving_stats;
                setCanMoveOnGrass(true);
	}

	public void addPet(Pet new_pet) {
		pets.adopt(new_pet);
		new_pet.adopt(this); // notify the new pet that this entity is the owner
	}
	
	public boolean is(Status status){
		return statuses.contains(status);
	}
	/**
	 * Adds a new status effect to this entity, if it does not already have the
	 * status applied.
	 * @param status
	 */
    public void addStatus(Status status) {
        if (!statuses.contains(status))
            statuses.push(status);
    }
    
    public void removeStatus(Status status){
    	statuses.remove(status);
    }

	public boolean addToInventory(NonEquippableItem item) {
		inventory.add(item);
		return true;
	}

	public int getAgility() {
		return stats.getAgility();
	}
    
    public Stats getStats() {
		return stats;
	}

	public int getArmorRating() {
		return stats.getArmorRating();
	}

	public int getDefensiveRating() {
		return stats.getDefensiveRating();
	}

	public int getEquippedArmor() {
		return stats.getEquippedArmor();
	}

	public int getEquippedWeapon() {
		return stats.getEquippedWeapon();
	}

	public int getExperience() {
		return stats.getExperience();
	}

	public int getHardiness() {
		return stats.getHardiness();
	}

	public int getIntellect() {
		return stats.getIntellect();
	}

	/**
	 * Gets this entity's inventory of unequipped items
	 * @return This entity's inventory as an Inventory reference
	 */
	public Inventory getInventory() { return inventory; }

	public int getMovement() {
		return stats.getMovement();
	}

	public int getLevel() {
		return stats.getLevel();
	}

	public int getLife() {
		return stats.getLife();
	}

	public int getLivesLeft() {
		return stats.getLivesLeft();
	}

	public int getMana() {
		return stats.getMana();
	}

	/**
	 * Gets the name of this entity.
	 * @return The entity's name as a String.
	 */
	@Override
	public String getName() {
		return this.name;
	}

	public int getOffensiveRating() {
		return stats.getOffensiveRating();
	}

	public int getStrength() {
		return stats.getStrength();
	}

	/**
	 * Merges a new stats set into this entity's collection of stats.
	 * @param stat The new set of stats to be merged
	 */
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
    
    public void setLife(int life){
        stats.setLife(life);
    }
    
    public void setLevel(int level){
        stats.setLevel(level);
    }

    public void setMovement(int movement) {
        stats.setMovement(movement);
    }

	protected void setName(String name) { this.name = name; }

    public void setStrength(int strength) {
        stats.setStrength(strength);
    }
    
    public void setMana(int mana) {
		stats.setMana(mana);
	}

    public void unMergeStats(Stats stat) {
        stats.unMergeStats(stat);
    }
    
    public void setCanMoveOnWater(boolean b){
        if(b){
            terrainTypesAllowedToMoveOn.add(TerrainType.Water);
        }else{
            terrainTypesAllowedToMoveOn.remove(TerrainType.Water);
        }
    }
    
    public ArrayList<TerrainType> getTerrainTypesAllowedToMoveOn() {
        return terrainTypesAllowedToMoveOn;
    }

    private void setCanMoveOnGrass(boolean b) {
        if(b){
            terrainTypesAllowedToMoveOn.add(TerrainType.Grass);
        }else{
            terrainTypesAllowedToMoveOn.remove(TerrainType.Grass);
        }
    }
    
    public String getAssetID(){
    	return id;
    }
    
    public void setAssetID(String id){
    	this.id=id;
    }

	public void visit(NonEquippableItem nonEquippableItem) {
		nonEquippableItem.touch(inventory);
	}

	public void visit(EquippableItem equippableItem) {
		equippableItem.touch(inventory);
	}

	public void visit(ActivationItem activationItem) {
		activationItem.touch(inventory);
	}

	public boolean visit(InteractiveItem interactiveItem) {
		return interactiveItem.receiveKey(getInventory(), getInventory().getActivationItems());
	}

	public void addTimedStatus(Status changeTo, String assetID, int length) {
		String _status = getAssetID();
		this.addStatus(changeTo);
		this.setAssetID(assetID);
		Timer timer = new Timer();
		final Entity e = this;
		TimerTask ttask = new TimerTask(){
			@Override
			public void run() {
				//e.removeStatus(changeTo);
				//e.setAssetID(_status);
			}
		};
		timer.schedule(ttask, 4 * 1000);
		
	}
	public boolean holds(String s){
		return false;
	}
	
	public abstract void accept(EntityVisitor visitor,VisitorContainer container);


}
