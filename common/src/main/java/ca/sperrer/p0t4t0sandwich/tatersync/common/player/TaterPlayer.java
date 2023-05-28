package ca.sperrer.p0t4t0sandwich.tatersync.common.player;

import java.util.UUID;

import static ca.sperrer.p0t4t0sandwich.tatersync.common.TaterSync.getServerName;

public class TaterPlayer {
    /**
     * Class used to abstract the player data to be used in the DataSource class.
     * playerName: The player's name.
     * playerUUID: The player's UUID.
     * currentServer: The server the player is currently on.
     */
    private final String playerName;
    private final UUID playerUUID;
    private final String currentServer;
    private final TaterInventory inventory;
    private final TaterInventory enderChest;

    /**
     * Constructor for the TaterPlayer class.
     * @param playerName The player's name.
     * @param playerUUID The player's UUID.
     */
    public TaterPlayer(String playerName, UUID playerUUID) {
        this.playerName = playerName;
        this.playerUUID = playerUUID;
        this.currentServer = getServerName();
        this.inventory = new TaterInventory(36);
        this.enderChest = new TaterInventory(27);
    }

    /**
     * Constructor for the TaterPlayer class.
     * @param playerName The player's name.
     * @param playerUUID The player's UUID.
     * @param inventory The player's inventory.
     */
    public TaterPlayer(String playerName, UUID playerUUID, TaterInventory inventory) {
        this.playerName = playerName;
        this.playerUUID = playerUUID;
        this.currentServer = getServerName();
        this.inventory = inventory;
        this.enderChest = new TaterInventory(27);
    }

    /**
     * Constructor for the TaterPlayer class.
     * @param playerName The player's name.
     * @param playerUUID The player's UUID.
     * @param inventory The player's inventory.
     * @param enderChest The player's ender chest.
     */
    public TaterPlayer(String playerName, UUID playerUUID, TaterInventory inventory, TaterInventory enderChest) {
        this.playerName = playerName;
        this.playerUUID = playerUUID;
        this.currentServer = getServerName();
        this.inventory = inventory;
        this.enderChest = enderChest;
    }

    /**
     * Get the player's name.
     * @return The player's name.
     */
    public String getName() {
        return this.playerName;
    }

    /**
     * Get the player's UUID.
     * @return The player's UUID.
     */
    public UUID getUUID() {
        return this.playerUUID;
    }

    /**
     * Get the server the player is currently on.
     * @return The server the player is currently on.
     */
    public String getCurrentServer() {
        return this.currentServer;
    }

    /**
     * Get the player's inventory.
     * @return The player's inventory.
     */
    public TaterInventory getInventory() {
        return this.inventory;
    }

    /**
     * Get the player's ender chest.
     * @return The player's ender chest.
     */
    public TaterInventory getEnderChest() {
        return this.enderChest;
    }
}
