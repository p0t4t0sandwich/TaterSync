package ca.sperrer.p0t4t0sandwich.tatersync.bukkit.test;

import ca.sperrer.p0t4t0sandwich.tatersync.bukkit.BukkitMain;
import ca.sperrer.p0t4t0sandwich.tatersync.common.player.TaterPlayer;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

import static ca.sperrer.p0t4t0sandwich.tatersync.bukkit.BukkitUtils.mapInventory;
import static ca.sperrer.p0t4t0sandwich.tatersync.bukkit.BukkitUtils.mapPlayer;
import static ca.sperrer.p0t4t0sandwich.tatersync.common.Utils.runTaskAsync;
import static ca.sperrer.p0t4t0sandwich.tatersync.common.nbt.NBTHandler.parseInventoryFromNBT;

public class TestInvCommand implements CommandExecutor {
    private final BukkitMain plugin = BukkitMain.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        AtomicBoolean success = new AtomicBoolean(false);
//        runTaskAsync(() -> {
            try {
                // Check if sender is a player
                if ((sender instanceof Player)) {
                    Player player = (Player) sender;

                    String text = "";

                    if (args.length == 0) {
                        success.set(false);
                        return false;
                    } else if (args.length == 1) {
                        TaterPlayer taterPlayer = mapPlayer(player);
                        switch (args[0]) {
                            case "store":
                                plugin.taterSync.inventoryData.storeInventory(taterPlayer);
                                text = "Stored inventory";
                                break;
                            case "load":
                                plugin.taterSync.inventoryData.loadInventory(taterPlayer);
                                text = "Loaded inventory";
                                break;
                            default:
                                success.set(false);
                                return false;
                        }
                    }

                    player.sendMessage("§2" + text);
                    success.set(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
//                System.err.println(Arrays.toString(e.getStackTrace()));
            }
//        });
        return success.get();
    }
}
