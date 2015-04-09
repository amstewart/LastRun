package model.map;

import model.Vector3;
import model.item.Item;
import utility.Util;

/**
 * Created by Alex Stewart on 15/04/09.
 */
public class ItemMovement extends Movement {

    private Item item;

    public ItemMovement(Item item, Vector3 position) {
        if (item == null) {
            Util.errOut(new Exception("ItemMovement association created with null item reference."));
        }

        initialize(item, position);
    }

    private void initialize(Item item, Vector3 position) {
        this.item = item;
        this.moveTo(position);
    }
}
