package model.movement;

import model.Vector2;
import model.item.Item;
import utility.Util;

/**
 * Created by Alex Stewart on 15/04/09.
 */
public class ItemMovement extends Movement {

    private Item item;

    public ItemMovement(Item item, Vector2 position) {
        if (item == null) {
            Util.errOut(new Exception("ItemMovement association created with null item reference."));
        }

        initialize(item, position);
    }

    private void initialize(Item item, Vector2 position) {
        this.item = item;
        this.changePosition(position);
    }
}
