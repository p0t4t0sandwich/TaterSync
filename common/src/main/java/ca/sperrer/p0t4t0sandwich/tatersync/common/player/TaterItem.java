package ca.sperrer.p0t4t0sandwich.tatersync.common.player;

import java.util.HashMap;
import java.util.Map;

public class TaterItem {
    /**
     * Class used to abstract the player inventory item data
     * id: The item's id.
     * count: The item's count.
     * damage: The item's damage.
     * meta: The item's metadata.
     */
    private final String id;
    private final int amount;
    private final TaterItemMeta meta;

    /**
     * Constructor for the TaterItem class.
     * @param id The item's id.
     * @param amount The item's count.
     */
    public TaterItem(String id, int amount) {
        this.id = id;
        this.amount = amount;
        this.meta = new TaterItemMeta(0, "", new String[0]);
    }

    /**
     * Constructor for the TaterItem class.
     * @param id The item's id.
     * @param amount The item's count.
     * @param meta The item's metadata.
     */
    public TaterItem(String id, int amount, TaterItemMeta meta) {
        this.id = id;
        this.amount = amount;
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
    public int getAmount() {
        return this.amount;
    }

    /**
     * Get the item's metadata.
     * @return The item's metadata.
     */
    public TaterItemMeta getMeta() {
        return this.meta;
    }

    public HashMap<String, Object> serialize() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("amount", this.amount);
        if (this.meta != null) {
            map.put("meta", new HashMap<>());
//            map.put("meta", this.meta.serialize());
        }
        return map;
    }
}
