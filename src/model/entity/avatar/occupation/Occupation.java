package model.entity.avatar.occupation;

import model.item.Inventory;
import model.item.equipment.*;

public abstract class Occupation {

    public Occupation(Inventory inventory) {}

    // Subclasses responsible for overriding items that can equip
    public abstract boolean addToEquipment(BasicEquipment equipment);

    public abstract boolean addToEquipment(SmasherEquipment equipment);

    public abstract boolean addToEquipment(SneakEquipment equipment);

    public abstract boolean addToEquipment(SummonerEquipment equipment);

    public abstract Equipment[] getEquipment();
}
