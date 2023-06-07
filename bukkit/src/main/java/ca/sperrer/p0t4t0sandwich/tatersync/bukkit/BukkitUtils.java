package ca.sperrer.p0t4t0sandwich.tatersync.bukkit;

import ca.sperrer.p0t4t0sandwich.tatersync.common.player.TaterItem;
import ca.sperrer.p0t4t0sandwich.tatersync.common.player.TaterItemTag;
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
    public static TaterItem mapItemStack(ItemStack itemStack, int Slot) {
        if (itemStack == null) {
            return null;
        }

        ItemMeta itemMeta = itemStack.getItemMeta();
        Map<String, Object> serializedItem = itemStack.serialize();

        //
        System.out.println("Item: " + serializedItem);
        //

        TaterItemTag inventoryItemMeta = null;
        if (itemMeta != null) {
            Map<String, Object> serializedMeta = itemMeta.serialize();

            //
            System.out.println("ItemMeta: " + serializedMeta);
            //

            inventoryItemMeta = new TaterItemTag();

            inventoryItemMeta.setDamage((int) serializedMeta.getOrDefault("Damage", 0));
        }

        return new TaterItem(
                Slot,
                "minecraft:" + ((String) serializedItem.get("type")).toLowerCase(),
                (int) serializedItem.getOrDefault("amount", 1),
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
        TaterItem[] items = new TaterItem[0];
        for (int i = 0; i < inventory.getSize(); i++) {
            if (bukkitItems[i] == null || bukkitItems[i].getType() == Material.AIR) {
                continue;
            }
            TaterItem[] newItems = new TaterItem[items.length + 1];
            System.arraycopy(items, 0, newItems, 0, items.length);
            newItems[items.length] = mapItemStack(bukkitItems[i], i);
            items = newItems;
        }
        return new TaterInventory(inventory.getSize(), items);
    }
}
