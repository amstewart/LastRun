/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

/**
 *
 * @author
 */

public class Location {
    private int x;
    private int y;
    private int z;
    
    public Location(){
        
    }
    
    public Location(int x, int y, int z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    
    public Location add(Location loc){
        this.x+=loc.getX();
        this.y+=loc.getY();
        this.z+=loc.getZ();
        return this;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getZ(){
        return z;
    }
    
    public String toString(){
        return "Current Location: " + "(" + getX() + "," + getY() + "," + getZ() + ")";
    }
}
