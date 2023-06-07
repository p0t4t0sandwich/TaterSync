package ca.sperrer.p0t4t0sandwich.tatersync.common.player;

import java.util.HashMap;

public class TaterItemTagDisplay {
    /**
     * Class used to abstract an item's display metadata
     * color: The item's color.
     * Name: The item's display name.
     * Lore: The item's lore.
     */
    private int color = 0;
    private String Name = null;
    private String[] Lore = null;

    /**
     * Get the item's color.
     * @return The item's color.
     */
    public int getColor() {
        return this.color;
    }

    /**
     * Set the item's color.
     * @param color The item's color.
     */
    public void setColor(int color) {
        this.color = color;
    }

    /**
     * Get the item's display name.
     * @return The item's display name.
     */
    public String getName() {
        return this.Name;
    }

    /**
     * Set the item's display name.
     * @param Name The item's display name.
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * Get the item's lore.
     * @return The item's lore.
     */
    public String[] getLore() {
        return this.Lore;
    }

    /**
     * Set the item's lore.
     * @param Lore The item's lore.
     */
    public void setLore(String[] Lore) {
        this.Lore = Lore;
    }

    /**
     * Serialize the item's display metadata.
     * @return The serialized metadata.
     */
    public HashMap<String, Object> serialize() {
        HashMap<String, Object> serialized = new HashMap<>();
        if (this.color != 0) {
            serialized.put("color", this.color);
        }
        if (this.Name != null) {
            serialized.put("Name", this.Name);
        }
        if (this.Lore != null) {
            serialized.put("Lore", this.Lore);
        }

        return serialized;
    }
}
