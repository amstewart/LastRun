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
    GameMap map;
    HashMap<Entity,Location> entityToLocationMap;
    
    public MovementHandler(GameMap map){
           this.map=map;
           entityToLocationMap= new HashMap<Entity,Location>();
    }
    
    public void move(Entity e,Location loc){
       Location newEntityLocation=getLocation(e).add(loc); //need to have some sort of check
       
       updateLocation(e,newEntityLocation);
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
    
}

