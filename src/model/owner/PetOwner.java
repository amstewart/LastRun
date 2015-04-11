
package model.owner;

import java.util.HashSet;
import java.util.Set;
import model.entity.Entity;
import model.entity.npc.pet.Pet;

/**
 *
 * @author ChrisMoscoso
 */
public class PetOwner {
    
    public Set<Pet> slaves;
    
    public PetOwner(){
        slaves = new HashSet<>();
    }
    
    public int getNumberOwned(){
        return slaves.size();
    }
    
    public void adopt(Pet p){
        slaves.add(p);
    }
    
    public void release(Pet p){
        slaves.remove(p);
    }
}