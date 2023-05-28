package ca.sperrer.p0t4t0sandwich.tatersync.common.inventory;

import ca.sperrer.p0t4t0sandwich.tatersync.common.player.TaterInventory;
import ca.sperrer.p0t4t0sandwich.tatersync.common.player.TaterItem;
import ca.sperrer.p0t4t0sandwich.tatersync.common.player.TaterItemMeta;
import ca.sperrer.p0t4t0sandwich.tatersync.common.player.TaterPlayer;
import ca.sperrer.p0t4t0sandwich.tatersync.common.storage.Database;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

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
            String player_uuid = player.getUUID().toString();
            String currentServer = player.getCurrentServer();
            TaterInventory inventory = player.getInventory();
            TaterInventory enderChest = player.getEnderChest();

            MongoClient mongoClient = this.db.getConnection();
            String database = this.db.getDatabase();

            // Get player data
            MongoDatabase db = mongoClient.getDatabase(database);
            MongoCollection<Document> collection = db.getCollection("player_data");
            Document query = new Document("player_uuid", player_uuid);
            Document player_data = collection.find(query).first();

            // If player data doesn't exist, create it
            if (player_data == null) {
                Document new_player_data = new Document();
                new_player_data.append("player_name", player.getName());
                new_player_data.append("player_uuid", player_uuid);
                collection.insertOne(new_player_data);
            }

            // Store inventory data
            Document inventory_data = new Document();
            inventory_data.append("current_server", currentServer);
            inventory_data.append("inventory", inventory.serialize());
//            inventory_data.append("enderchest", enderChest.serialize());

            // Update inventory
            Document update = new Document("player_inventory", inventory_data);
            collection.updateOne(query, new Document("$set", update));

        } catch (Exception e) {
            System.err.println("Error storing inventory for player " + player.getName());
            e.printStackTrace();
        }
    }

    /**
     * @inheritDoc
     */
    public void loadInventory(TaterPlayer player) {
    }
}
