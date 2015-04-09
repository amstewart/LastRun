/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

import java.util.HashMap;
import model.entity.Entity;

/**
 *
 * @author
 */
public class MovementHandler {
    
    
    private final Location NORTH = new Location(0,1,-1);
    //Final locations here. Could just have another class that includes them.
    
    
    GameMap map;
    HashMap<Entity,Location> entityToLocationMap;
    boolean movable;
    
    
    public MovementHandler(GameMap map){
           this.map=map;
           entityToLocationMap= new HashMap<Entity,Location>();
           movable=false;
    }
    
    public void move(Entity e,Location loc){
       Location newEntityLocation=getLocation(e).add(loc); //need to have some sort of check
       Tile t= map.getTile(newEntityLocation);
       t.accept(this);
       if(movable==true){ //good enough for now.
           updateLocation(e,newEntityLocation);
           map.getTile(newEntityLocation).setStatus(new NonMovableStatus());
           map.getTile(loc).setStatus(new MovableStatus());
       }
       movable=false;
    }
    
    public void addEntity(Entity e,Location loc){
        entityToLocationMap.put(e,loc);
    }
    
    public Location getLocation(Entity e){
        return entityToLocationMap.get(e);
    }
    
    public void updateLocation(Entity e, Location loc){
        entityToLocationMap.put(e,loc);
    }
    
    public void visit(MovableStatus status){
       movable=true;
    }
    
    public void visit(NonMovableStatus status){
        movable=false;
    }
    
    public void visit(MovableWhenFlyingStatus status){
       movable=true;
    }
    
}

