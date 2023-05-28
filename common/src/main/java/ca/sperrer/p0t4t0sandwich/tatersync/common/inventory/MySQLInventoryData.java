package ca.sperrer.p0t4t0sandwich.tatersync.common.inventory;

import ca.sperrer.p0t4t0sandwich.tatersync.common.player.TaterPlayer;
import ca.sperrer.p0t4t0sandwich.tatersync.common.storage.Database;

import java.sql.Connection;

public class MySQLInventoryData implements InventoryData {
    private final Database<Connection> db;

    public MySQLInventoryData(Database<Connection> db) {
        this.db = db;
    }

    /**
     * @inheritDoc
     */
    public void storeInventory(TaterPlayer player)  {
    }

    /**
     * @inheritDoc
     */
    public void loadInventory(TaterPlayer player) {
    }
}
