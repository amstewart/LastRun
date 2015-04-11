/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tile;

import model.movement.MovementHandler;

/**
 *
 * @author
 */
public abstract class TileStatus {
    
    public abstract void accept(MovementHandler movementHandler);
    
}
