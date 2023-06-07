package ca.sperrer.p0t4t0sandwich.tatersync.common.player;

import java.util.HashMap;

public class TaterItem {
    /**
     * Class used to abstract the player inventory item data
     * Slot: The item's slot.
     * id: The item's id.
     * Count: The item's count.
     * meta: The item's metadata.
     */
    private final int Slot;
    private final String id;
    private final int Count;
    private final TaterItemTag meta;

    /**
     * Constructor for the TaterItem class.
     * @param Slot The item's slot.
     * @param id The item's id.
     * @param Count The item's count.
     */
    public TaterItem(int Slot, String id, int Count) {
        this.Slot = Slot;
        this.id = id;
        this.Count = Count;
        this.meta = null;
    }

    /**
     * Constructor for the TaterItem class.
     * @param Slot The item's slot.
     * @param id The item's id.
     * @param Count The item's count.
     * @param meta The item's metadata.
     */
    public TaterItem(int Slot, String id, int Count, TaterItemTag meta) {
        this.Slot = Slot;
        this.id = id;
        this.Count = Count;
        this.meta = meta;
    }

    /**
     * Get the item's slot.
     * @return The item's slot.
     */
    public int getSlot() {
        return this.Slot;
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
        return this.Count;
    }

    /**
     * Get the item's metadata.
     * @return The item's metadata.
     */
    public TaterItemTag getMeta() {
        return this.meta;
    }

    /**
     * Serialize the TaterItem class.
     * @return The serialized TaterItem class.
     */
    public HashMap<String, Object> serialize() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("Slot", this.Slot);
        map.put("id", this.id);
        map.put("Count", this.Count);
        if (this.meta != null) {
            map.put("tag", this.meta.serialize());
        }
        return map;
    }
}
