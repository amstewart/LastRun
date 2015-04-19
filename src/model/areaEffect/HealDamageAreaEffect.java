/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.areaEffect;

import model.entity.Entity;

public class HealDamageAreaEffect extends AreaEffect {

    private double healPercentage;
   
    public HealDamageAreaEffect()   {
       healPercentage=.5;
    }
   
    public HealDamageAreaEffect(String id)  {
	    super(id);
        healPercentage=.5;
    }

    public void apply(Entity e){
        e.setLife(newHealth(e));
    }

    public int newHealth(Entity e)  {
        int avatarCurrLife= e.getLife();
        int add= (int)(avatarCurrLife*healPercentage);
        return avatarCurrLife+add;
    }
}
