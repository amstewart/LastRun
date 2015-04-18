package model.tile;

import java.util.Set;

import model.Vector2;
import model.areaEffect.AreaEffect;
import model.effect.Projectile;
import model.entity.Entity;
import model.entity.npc.pet.Pet;
import model.entity.vehicle.Vehicle;
import model.item.Item;
import model.owner.AreaEffectOwner;
import model.owner.EntityOwner;
import model.owner.ItemOwner;
import model.owner.PetOwner;
import model.owner.ProjectileOwner;
import model.owner.TerrainOwner;
import model.owner.VehicleOwner;
import model.terrain.Terrain;
import utility.Util;

public class Tile {

    private Vector2 address;

    private AreaEffectOwner myAreaEffects;
    private EntityOwner myEntities;
    private ItemOwner myItems;
    private PetOwner myPets;
    private TerrainOwner myTerrains;
    private VehicleOwner myVehicles;
    private ProjectileOwner myProjectiles;
    
    public Tile(){
        
    }
    

    public Tile(Vector2 location) {
        address = location;
    }
    
    public void addAreaEffect(AreaEffect a) {
        if (!isAreaEffectOwner()) {
            myAreaEffects = new AreaEffectOwner();
        }
        myAreaEffects.adopt(a);
    }

    public void removeAreaEffect(AreaEffect a) {
        if (isAreaEffectOwner()) {
            myAreaEffects.release(a);
            if(myAreaEffects.getNumberOwned() == 0){
                myAreaEffects = null;
            }
        } else {
            Util.dbgOut("I can't release " + a + " because I am not an entity owner", 3);
        }        
    }
    
    public void addProjectile(Projectile p) {
        if (!isProjectileOwner()) {
            myProjectiles = new ProjectileOwner();
        }
        myProjectiles.adopt(p);
    }

    public void removeProjectile(Projectile p) {
        if (isProjectileOwner()) {
        	myProjectiles.release(p);
            if(myProjectiles.getNumberOwned() == 0){
            	myProjectiles = null;
            }
        } else {
            Util.dbgOut("I can't release " + p + " because I am not an entity owner", 3);
        }        
    }

    public void addEntity(Entity e) {
        if (!isEntityOwner()) {
            myEntities = new EntityOwner();
        }
        myEntities.adopt(e);
    }

    public void removeEntity(Entity e) {
        if (isEntityOwner()) {
            myEntities.release(e);
            if(myEntities.getNumberOwned() == 0){
                myEntities = null;
            }
        } else {
            Util.dbgOut("I can't release " + e.getName() + " because I am not an entity owner", 3);
        }
    }

    public void addItem(Item i) {
        if (!isItemOwner()) {
            myItems = new ItemOwner();
        }
        myItems.adopt(i);
    }

    public void removeItem(Item i) {
        if (isItemOwner()) {
            myItems.release(i);
            if(myItems.getNumberOwned() == 0){
                myItems = null;
            }
        } else {
            Util.dbgOut("I can't release " + i.getName() + " because I am not an item owner", 3);
        }
    }
    

    public void addPet(Pet p) {
        if (!isPetOwner()) {
            myPets = new PetOwner();
        }
        myPets.adopt(p);
    }

    public void removePet(Pet p) {
        if (isPetOwner()) {
            myPets.release(p);
            if(myPets.getNumberOwned() == 0){
                myPets = null;
            }
        } else {
            Util.dbgOut("I can't release " + p.getName() + " because I am not an pet owner", 3);
        }
    }
    
    public void addTerrain(Terrain t) {
        if (!isTerrainOwner()) {
            myTerrains = new TerrainOwner();
        }
        myTerrains.adopt(t);
    }

    public void removeTerrain(Terrain t) {
        if (isTerrainOwner()) {
            myTerrains.release(t);
            if(myTerrains.getNumberOwned() == 0){
                myTerrains = null;
            }
        } else {
            Util.dbgOut("I can't release " + t + " because I am not an terrain owner", 3);
        }
    }

    public void addVehicle(Vehicle v) {
        if (!isVehicleOwner()) {
            myVehicles = new VehicleOwner();
        }
        myVehicles.adopt(v);
    }

    public void removeVehicle(Vehicle v) {
        if (isVehicleOwner()) {
            myVehicles.release(v);
            if(myVehicles.getNumberOwned() == 0){
                myVehicles = null;
            }
        } else {
            Util.dbgOut("I can't release " + v + " because I am not an vehicle owner", 3);
        }
    }

    public boolean isAreaEffectOwner() {
        return myAreaEffects != null;
    }

    public boolean isEntityOwner() {
        return myEntities != null;
    }

    public boolean isItemOwner() {
        return myItems != null;
    }

    public boolean isPetOwner() {
        return myPets != null;
    }

    public boolean isTerrainOwner() {
        return myTerrains != null;
    }

    public boolean isVehicleOwner() {
        return myVehicles != null;
    }

    public boolean isProjectileOwner() {
        return myProjectiles != null;
    }

    public Vector2 getLocation() {
        return address;
    }
    
    public Terrain getTerrain(){
        return myTerrains.getTerrain();
    }
    
    public AreaEffect getAreaEffect(){
        return myAreaEffects.getAreaEffect();
    }
    
    public Entity getEntity(){
        return myEntities.getEntity();
    }
    
    public Vehicle getVehicle(){
        return myVehicles.getVehicle();
    }
    
    public Item getItem(){
        return myItems.getItem();
    }
    
    public Pet getPet(){
        return myPets.getPet();
    }
    
    protected PetOwner getPetOwner(){
        return myPets;
    }
    
    protected AreaEffectOwner getAreaEffectOwner(){
        return myAreaEffects;
    }
    
    protected TerrainOwner getTerrainOwner(){
         return myTerrains;
    }
     
    protected VehicleOwner getVehicleOwner(){
          return myVehicles;
    }
      
    protected ItemOwner getItemOwner(){
          return myItems;
    }
       
    protected EntityOwner getEntityOwner(){
          return myEntities;
    }


	public void accept(Entity e) {
		if(myItems != null){
			Set<Item> items = myItems.getItems();
			for(Item i: items){
				i.accept(e,this);
			}
		}
	}


	public void accept(Projectile p, Boolean affect) {
		if(myEntities != null){
			affect = true;
			Set<Entity> ents = myEntities.getEntities();
			for(Entity e: ents){
				p.affect(e);
			}
		}
	}


	public Projectile getProjectile() {
		return myProjectiles.getProjectile();
	}
    
}
