package model.entity.occupation;

import model.item.EquipmentManager;
import model.item.Inventory;
import model.item.SmasherEquipmentManager;
import model.item.equipment.*;

public abstract class Occupation {

    public Occupation(Inventory inventory) {}

    // God this is horrible, but I can't think of another way right now
    // Subclasses responsible for overriding items that can equip
    public abstract boolean addToEquipment(BasicEquipment equipment);

    public abstract boolean addToEquipment(SmasherEquipment equipment);

    public abstract boolean addToEquipment(SneakEquipment equipment);

    public abstract boolean addToEquipment(SummonerEquipment equipment);

    public abstract boolean removeFromEquipment(BasicEquipment equipment);

    public abstract boolean removeFromEquipment(SmasherEquipment equipment);

    public abstract boolean removeFromEquipment(SneakEquipment equipment);

    public abstract boolean removeFromEquipment(SummonerEquipment equipment);

    public abstract EquipmentManager getEquipmentManager();

    public abstract Equipment[] getEquipment();
    //=====TEMP TESTING======
    public abstract String getName();
}
