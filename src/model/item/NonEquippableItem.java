package model.item;
// Nonequippable Items are items that can only be used... like One shot Item
public class NonEquippableItem extends TakeableItem {

    public NonEquippableItem(String name) {
        super(name);
    }

    @Override
    public void touch(Inventory inventory) {
        inventory.add(this);
    }

    // will pass in stats or something form the avatar/entity
    public void use() {
        System.out.println("You just used " + this.getName());
        // todo
    }
}
