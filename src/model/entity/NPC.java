/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;


public class NPC extends Entity {
    Occupation occupation;

    public NPC (String art_asset) {
        super(art_asset);
    }

    public String getDescription() { return "I am an NPC."; } //TODO Make better.
}
