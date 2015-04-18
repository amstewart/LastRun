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
public class InstantDeathAreaEffect extends AreaEffect {
	
	public InstantDeathAreaEffect(){}
	
	public InstantDeathAreaEffect(String id){
		super(id);
	}
    
    public void apply(Entity e){
       e.setLivesLeft(e.getLivesLeft()-1);
    }
    
}
