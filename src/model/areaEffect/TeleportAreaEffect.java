/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.areaEffect;

import model.Vector2;
import model.entity.Entity;
import model.map.GameMap;

public class TeleportAreaEffect extends AreaEffect {

    private Vector2 location;
    private GameMap gameMap;

    public TeleportAreaEffect(Vector2 location){ //add assetable stuff here
        this.location=location;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    @Override
    public void apply(Entity e) {
        gameMap.moveAvatarTo(location);
    }
}
