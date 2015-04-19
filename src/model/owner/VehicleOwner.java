
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
    
    public Vehicle slave;
    
    public VehicleOwner(){
    }
    
    public int getNumberOwned(){
        if (slave == null) return 0;
        else return 1;
    }
    
    public void adopt(Vehicle v){
        slave = v;
    }
    
    public void release(){
        slave = null;
    }
    
    public Vehicle getVehicle(){
        return slave;
    }
}
