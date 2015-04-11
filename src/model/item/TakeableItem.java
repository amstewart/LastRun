/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.item;

import model.entity.Entity;
import model.entity.avatar.Avatar;
import model.entity.avatar.occupation.Occupation;

public abstract class TakeableItem extends Item{

    public TakeableItem(String name, int value){

        super(name, value);
    }

    @Override
    public boolean touch(Entity entity) {
        return entity.addToInventory(this);
    }

    public abstract boolean use(Occupation occupation);
}
