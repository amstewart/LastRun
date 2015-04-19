/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.areaEffect;

import model.Vector2;
import model.entity.Entity;

public class TeleportAreaEffect extends AreaEffect {

    private Vector2 location;
    
    public TeleportAreaEffect(Vector2 location){ //add assetable stuff here
        this.location=location;
    }

    @Override
    public void apply(Entity e) {
        //change the entity's location and draw him somewhere else on the map.
    }
}
