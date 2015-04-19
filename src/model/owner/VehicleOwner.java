
package model.owner;

import java.util.HashSet;
import java.util.Set;
import model.entity.Entity;
import model.entity.Status;
import model.entity.vehicle.Vehicle;

/**
 *
 * @author ChrisMoscoso
 */
public class VehicleOwner {
    
    private Vehicle slave;
    private Entity rider;
    
    public VehicleOwner(){
    }

    public void adopt(Vehicle v){
        slave = v;
        if (isMounted())
            unmount();
    }
    
    public int getNumberOwned(){
        if (slave == null) return 0;
        else return 1;
    }

    public Entity getRider() { return rider; }

    public Vehicle getVehicle(){
        return slave;
    }

    public boolean isMounted() {
        if (rider == null) return false;
        else return true;
    }

    public void mount(Entity new_rider) {
        if (rider != null) {
            unmount();
        }

        rider = new_rider;
        rider.addStatus(Status.MOUNTED);
    }

    public void release(){
        slave = null;
        if (isMounted())
            unmount();
    }

    public void toggleMount(Entity new_rider) {
        if (isMounted()) {
            unmount();
        } else {
            mount(new_rider);
        }
    }

    public void unmount() {
        if (rider != null) { rider.removeStatus(Status.MOUNTED); }
        rider = null;
    }
}
