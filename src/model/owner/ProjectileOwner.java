package model.owner;

import java.util.HashSet;
import java.util.Set;

import model.effect.Projectile;

public class ProjectileOwner {
private Set<Projectile> slaves;
    
    public ProjectileOwner(){
        slaves = new HashSet<Projectile>();
    }
    
    public void adopt(Projectile p){
        slaves.add(p);
    }
    
    public void release(Projectile p){
        slaves.remove(p);
    }
    
    public int getNumberOwned(){
        return slaves.size();
    }
    
    public Projectile getProjectile(){
    	Projectile e=null;
        for(Projectile projectile : slaves){
            e=projectile;
        }
        return e;
    }

}
