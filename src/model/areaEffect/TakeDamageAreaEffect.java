/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.areaEffect;

import model.entity.Entity;

/**
 *
 * @author
 */
public class TakeDamageAreaEffect extends AreaEffect {
    private double damage;
    
    public TakeDamageAreaEffect(){
        damage=.50;
    }
    
    public TakeDamageAreaEffect(String id){
    	super(id);
        damage=.50;
    }
    
    public void apply(Entity e){
        e.setLife(newHealth(e));

    }
    
    public int newHealth(Entity e){
        int avatarCurrLife=e.getLife();
        int remove= (int)(avatarCurrLife*damage);
        return avatarCurrLife-remove;
    }

 

  
    
}
