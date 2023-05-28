package ca.sperrer.p0t4t0sandwich.tatersync.common.storage;

import ca.sperrer.p0t4t0sandwich.tatersync.common.inventory.InventoryData;
import ca.sperrer.p0t4t0sandwich.tatersync.common.inventory.MongoDBInventoryData;
import ca.sperrer.p0t4t0sandwich.tatersync.common.inventory.MySQLInventoryData;
import dev.dejvokep.boostedyaml.YamlDocument;

import java.util.Arrays;


public class DataSource {
    /**
     * Get the database
     * @param type The type of database
     * @param config The config file
     * @return The database
     */
    public static Database getDatabase(String type, YamlDocument config) {
        try {
            switch (type) {
                case "mysql":
                    return new MySQLDatabase(config);
                case "mongodb":
                    return new MongoDBDatabase(config);
                default:
                    return null;
            }
        } catch (Exception e) {
            System.err.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    /**
     * Get the inventory data class
     * @param database The database
     * @return The inventory data class
     */
    public static InventoryData getInventoryData(Database database) {
        try {
            switch (database.getType()) {
                case "mysql":
                    return new MySQLInventoryData(database);
                case "mongodb":
                    return new MongoDBInventoryData(database);
                default:
                    return null;
            }
        } catch (Exception e) {
            System.err.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }
}