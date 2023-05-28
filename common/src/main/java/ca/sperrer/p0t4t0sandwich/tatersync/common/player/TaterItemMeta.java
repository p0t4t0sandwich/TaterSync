package ca.sperrer.p0t4t0sandwich.tatersync.common.player;

import java.util.Arrays;
import java.util.HashMap;

public class TaterItemMeta {
    /**
     * Class used to abstract an item's metadata
     * damage: The item's damage.
     * displayName: The item's display name.
     * lore: The item's lore.
     */
    private final int damage;
    private final String displayName;
    private final String[] lore;

    /**
     * Constructor for the TaterItemMeta class.
     * @param displayName The item's display name.
     * @param lore The item's lore.
     */
    public TaterItemMeta(int damage, String displayName, String[] lore) {
        this.damage = damage;
        this.displayName = displayName;
        this.lore = lore;
    }

    /**
     * Get the item's display name.
     * @return The item's display name.
     */
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * Get the item's lore.
     * @return The item's lore.
     */
    public String[] getLore() {
        return this.lore;
    }

    /**
     * Get the item's damage.
     * @return The item's damage.
     */
    public int getDamage() {
        return this.damage;
    }

    public HashMap<String, Object> serialize() {
        HashMap<String, Object> serialized = new HashMap<>();
        serialized.put("damage", this.damage);
        serialized.put("displayName", this.displayName);
        serialized.put("lore", this.lore);

        System.out.println("Damage: " + this.damage);
        System.out.println("Display Name: " + this.displayName);
        System.out.println("Lore: " + Arrays.toString(this.lore));

        return serialized;
    }
}
