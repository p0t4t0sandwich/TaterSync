package ca.sperrer.p0t4t0sandwich.tatersync.common.player;

public class TaterItem {
    /**
     * Class used to abstract the player inventory item data
     * id: The item's id.
     * count: The item's count.
     * damage: The item's damage.
     * meta: The item's metadata.
     */
    private final String id;
    private final int count;
    private final int damage;
    private final TaterItemMeta meta;

    /**
     * Constructor for the TaterItem class.
     * @param id The item's id.
     * @param count The item's count.
     * @param damage The item's damage.
     */
    public TaterItem(String id, int count, int damage) {
        this.id = id;
        this.count = count;
        this.damage = damage;
        this.meta = null;
    }

    /**
     * Constructor for the TaterItem class.
     * @param id The item's id.
     * @param count The item's count.
     * @param damage The item's damage.
     * @param meta The item's metadata.
     */
    public TaterItem(String id, int count, int damage, TaterItemMeta meta) {
        this.id = id;
        this.count = count;
        this.damage = damage;
        this.meta = meta;
    }

    /**
     * Get the item's id.
     * @return The item's id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Get the item's count.
     * @return The item's count.
     */
    public int getCount() {
        return this.count;
    }

    /**
     * Get the item's damage.
     * @return The item's damage.
     */
    public int getDamage() {
        return this.damage;
    }

    /**
     * Get the item's metadata.
     * @return The item's metadata.
     */
    public TaterItemMeta getMeta() {
        return this.meta;
    }
}
