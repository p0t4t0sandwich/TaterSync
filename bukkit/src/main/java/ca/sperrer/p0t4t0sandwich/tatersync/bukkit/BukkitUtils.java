package ca.sperrer.p0t4t0sandwich.tatersync.bukkit;

import ca.sperrer.p0t4t0sandwich.tatersync.common.player.TaterItem;
import ca.sperrer.p0t4t0sandwich.tatersync.common.player.TaterItemMeta;
import ca.sperrer.p0t4t0sandwich.tatersync.common.player.TaterPlayer;
import ca.sperrer.p0t4t0sandwich.tatersync.common.player.TaterInventory;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;

public class BukkitUtils {
    /**
     * Maps a Bukkit Player to a TaterPlayer.
     * @param player Bukkit Player
     * @return TaterPlayer
     */
    public static TaterPlayer mapPlayer(Player player) {
        return new TaterPlayer(
                player.getName(),
                player.getUniqueId(),
                mapInventory(player.getInventory()),
                mapInventory(player.getEnderChest())
        );
    }

    /**
     * Maps a Bukkit ItemStack to an TaterItem.
     * @param itemStack Bukkit ItemStack
     * @return TaterItem
     */
    public static TaterItem mapItemStack(ItemStack itemStack) {
        if (itemStack == null) {
            return new TaterItem(Material.AIR.toString(), 0);
        }

        ItemMeta itemMeta = itemStack.getItemMeta();
        Map<String, Object> serializedItem = itemStack.serialize();

        //
        System.out.println("Item: " + serializedItem);
        //

        TaterItemMeta inventoryItemMeta = new TaterItemMeta(0, "", new String[0]);
        if (itemMeta != null) {
            Map<String, Object> serializedMeta = itemMeta.serialize();

            //
            System.out.println("ItemMeta: " + serializedMeta);
            //

            inventoryItemMeta = new TaterItemMeta(
                    (int) serializedMeta.getOrDefault("Damage", 0),
                    (String) serializedMeta.getOrDefault("displayName", ""),
                    (String[]) serializedMeta.getOrDefault("lore", new String[0])
            );
        }

        return new TaterItem(
                (String) serializedItem.getOrDefault("type", Material.AIR.toString()),
                (int) serializedItem.getOrDefault("amount", 0),
                inventoryItemMeta
        );

    }

    /**
     * Maps a Bukkit Inventory to a TaterInventory.
     * @param inventory Bukkit Inventory
     * @return TaterInventory
     */
    public static TaterInventory mapInventory(Inventory inventory) {
        ItemStack[] bukkitItems = inventory.getContents();
        TaterItem[] items = new TaterItem[inventory.getSize()];
        for (int i = 0; i < inventory.getSize(); i++) {
            items[i] = mapItemStack(bukkitItems[i]);
        }
        return new TaterInventory(inventory.getSize(), items);
    }
}
