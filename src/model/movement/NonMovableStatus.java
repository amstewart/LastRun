/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.movement;

import model.tile.TileStatus;

/**
 *
 * @author
 */
public class NonMovableStatus extends TileStatus {
    
    
    public void accept(MovementHandler movementHandler){
        movementHandler.visit(this);
    }
    
}
