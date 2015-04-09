package model.entity;

import model.item.equipment.BasicEquipment;
import model.item.equipment.SmasherEquipment;
import model.item.equipment.SneakEquipment;
import model.item.equipment.SummonerEquipment;

public interface Equippable {

    boolean addToEquipment(BasicEquipment equipment);

    boolean addToEquipment(SmasherEquipment equipment);

    boolean addToEquipment(SneakEquipment equipment);

    boolean addToEquipment(SummonerEquipment equipment);
}
