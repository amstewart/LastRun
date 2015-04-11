
package model.owner;

import java.util.HashSet;
import java.util.Set;
import model.entity.Entity;
import model.entity.vehicle.Vehicle;

/**
 *
 * @author ChrisMoscoso
 */
public class VehicleOwner {
    
    public Set<Vehicle> slaves;
    
    public VehicleOwner(){
        slaves = new HashSet<Vehicle>();
    }
    
    public int getNumberOwned(){
        return slaves.size();
    }
    
    public void adopt(Vehicle v){
        slaves.add(v);
    }
    
    public void release(Vehicle v){
        slaves.remove(v);
    }
}
