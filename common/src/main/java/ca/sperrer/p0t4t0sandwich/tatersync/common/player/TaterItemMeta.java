package ca.sperrer.p0t4t0sandwich.tatersync.common.player;

public class TaterItemMeta {
    /**
     * Class used to abstract an item's metadata
     * displayName: The item's display name.
     * lore: The item's lore.
     */
    private final String displayName;
    private final String[] lore;

    /**
     * Constructor for the TaterItemMeta class.
     * @param displayName The item's display name.
     * @param lore The item's lore.
     */
    public TaterItemMeta(String displayName, String[] lore) {
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
}
