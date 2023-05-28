package ca.sperrer.p0t4t0sandwich.tatersync.common.inventory;

import ca.sperrer.p0t4t0sandwich.tatersync.common.player.TaterPlayer;
import ca.sperrer.p0t4t0sandwich.tatersync.common.storage.Database;

public interface InventoryData {
    Database db = null;

    void storeInventory(TaterPlayer player);

    void loadInventory(TaterPlayer player);
}
