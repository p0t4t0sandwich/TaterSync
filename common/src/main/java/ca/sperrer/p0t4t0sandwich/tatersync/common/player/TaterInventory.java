package ca.sperrer.p0t4t0sandwich.tatersync.common.player;

public class TaterInventory {
    /**
     * Class used to abstract the player inventory data
     * size: The size of the inventory.
     * items: The items in the inventory.
     */
    int size;
    TaterItem[] items;

    /**
     * Constructor for the TaterInventory class.
     * @param size The size of the player's inventory.
     */
    public TaterInventory(int size) {
        this.size = size;
        this.items = new TaterItem[size];
    }

    /**
     * Constructor for the TaterInventory class.
     * @param size The size of the inventory.
     * @param items The items in the inventory.
     */
    public TaterInventory(int size, TaterItem[] items) {
        this.size = size;
        this.items = items;
    }

    /**
     * Get the size of the inventory.
     * @return The size of the inventory.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Set the size of the inventory.
     * @return The size of the inventory.
     */
    public TaterItem[] getItems() {
        return this.items;
    }

    /**
     * Set the items in the inventory.
     * @param items The items to set.
     */
    public void setItems(TaterItem[] items) {
        this.items = items;
    }

    /**
     * Get the item at the specified index.
     * @param index The index of the item to get.
     * @return The item at the specified index.
     */
    public TaterItem getItem(int index) {
        return this.items[index];
    }

    /**
     * Set the item at the specified index.
     * @param index The index of the item to set.
     * @param item The item to set.
     */
    public void setItem(int index, TaterItem item) {
        this.items[index] = item;
    }

//    public void setItem(int index, int id, int count, int damage) {
//        this.items[index] = new TaterItem(id, count, damage);
//    }
}
