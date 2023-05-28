package ca.sperrer.p0t4t0sandwich.tatersync.common.inventory;

import ca.sperrer.p0t4t0sandwich.tatersync.common.player.TaterInventory;
import ca.sperrer.p0t4t0sandwich.tatersync.common.player.TaterItem;
import ca.sperrer.p0t4t0sandwich.tatersync.common.player.TaterItemMeta;
import ca.sperrer.p0t4t0sandwich.tatersync.common.player.TaterPlayer;
import ca.sperrer.p0t4t0sandwich.tatersync.common.storage.Database;
import com.mongodb.client.MongoClient;

import java.util.Arrays;

public class MongoDBInventoryData implements InventoryData {
    private final Database<MongoClient> db;

    public MongoDBInventoryData(Database<MongoClient> db) {
        this.db = db;
    }

    /**
     * @inheritDoc
     */
    public void storeInventory(TaterPlayer player) {
        try {
            String playerUUID = player.getUUID().toString();
            String currentServer = player.getCurrentServer();
            TaterInventory inventory = player.getInventory();
            TaterInventory enderChest = player.getEnderChest();

            for (int i = 0; i < inventory.getSize(); i++) {
                TaterItem item = inventory.getItem(i);
                TaterItemMeta meta = item.getMeta();

                System.out.println("Storing item: " + item.toString());
            }

        } catch (Exception e) {
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
    }

    /**
     * @inheritDoc
     */
    public void loadInventory(TaterPlayer player) {
    }
}
