package testing;

import model.item.TakeableItem;

import model.entity.Avatar;
import model.entity.occupation.Occupation;
import model.item.equipment.*;

public class EquipmentTest extends Test {

    @Override
    public void run() throws NoSuchMethodException {
        Avatar avatar = new Avatar();
        avatar.beSmasher();

        Head head = new Head("Head", 100);
        Chest chest = new Chest("Chest", 100);
        Legs legs = new Legs("Legs", 100);
        OneHandedWeapon oneHand = new OneHandedWeapon("Sword", 250);
        TwoHandedWeapon twoHand = new TwoHandedWeapon("Huge Sword", 250);
        Shield shield = new Shield("Shield", 300);
        Staff staff = new Staff("Staff", 35);
        Range range = new Range("Range", 10);

        avatar.addToInventory(head);
        avatar.addToInventory(chest);
        avatar.addToInventory(legs);
        avatar.addToInventory(oneHand);
        avatar.addToInventory(twoHand);
        avatar.addToInventory(shield);
        avatar.addToInventory(staff);
        avatar.addToInventory(range);

        TakeableItem[] items = avatar.getInventoryItems();
        Occupation occupation = avatar.getOccupation();

        for(int i = 0; i < items.length; i++ ) {
            System.out.println("Success?: " + items[i].use(occupation));
        }

        System.out.println("=========Items Equipped=======");
        Equipment[] equipment = avatar.getEquipment();
        for(int i = 0; i < equipment.length; i++) {
            if(equipment[i] != null) {
                System.out.println(equipment[i].getName());
            }
        }

        System.out.println("=========items in Inventory===");
        TakeableItem[] items2 = avatar.getInventoryItems();
        for(int i = 0; i < items2.length; i++) {
            System.out.println(items2[i].getName());
        }


        report("Equipment check", true);


    }
}
