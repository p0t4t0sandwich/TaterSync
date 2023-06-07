package ca.sperrer.p0t4t0sandwich.tatersync.common.player;

import java.util.HashMap;

public class TaterItemTag {
    /**
     * Class used to abstract an item's metadata
     * damage: The item's damage.
     * displayName: The item's display name.
     * lore: The item's lore.
     */
    private int Damage = 0;
    private TaterItemTagDisplay display = null;

    /**
     * Get the item's damage.
     * @return The item's damage.
     */
    public int getDamage() {
        return this.Damage;
    }

    /**
     * Set the item's damage.
     * @param damage The item's damage.
     */
    public void setDamage(int damage) {
        this.Damage = damage;
    }

    /**
     * Get the item's display metadata.
     * @return The item's display metadata.
     */
    public TaterItemTagDisplay getDisplay() {
        return this.display;
    }

    /**
     * Set the item's display metadata.
     * @param display The item's display metadata.
     */
    public void setDisplay(TaterItemTagDisplay display) {
        this.display = display;
    }

    /**
     * Serialize the item's metadata.
     * @return The serialized metadata.
     */
    public HashMap<String, Object> serialize() {
        HashMap<String, Object> serialized = new HashMap<>();
        if (this.Damage != 0) {
            serialized.put("Damage", this.Damage);
        }
        if (this.display != null) {
            serialized.put("display", this.display.serialize());
        }

        return serialized;
    }
}
