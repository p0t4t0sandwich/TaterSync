package ca.sperrer.p0t4t0sandwich.tatersync.bukkit;

import ca.sperrer.p0t4t0sandwich.tatersync.bukkit.listeners.BukkitEventListener;
import ca.sperrer.p0t4t0sandwich.tatersync.bukkit.test.TestInvCommand;
import ca.sperrer.p0t4t0sandwich.tatersync.common.TaterSync;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

import static ca.sperrer.p0t4t0sandwich.tatersync.common.Utils.*;

public class BukkitMain extends JavaPlugin {
    public TaterSync taterSync;

    // Singleton instance
    private static BukkitMain instance;
    public static BukkitMain getInstance() {
        return instance;
    }

    public String getServerType() {
        if (isMagma()) {
            return "Magma";
        } else if (isMohist()) {
            return "Mohist";
        } else if (isArclight()) {
            return "Arclight";
        } else if (isFolia()) {
            return "Folia";
        } else if (isPaper()) {
            return "Paper";
        } else if (isSpigot()) {
            return "Spigot";
        } else if (isCraftBukkit()) {
            return "CraftBukkit";
        } else {
            return "Unknown";
        }
    }

    @Override
    public void onEnable() {
        // Singleton instance
        instance = this;

        getLogger().info("TaterSync is running on " + getServerType() + ".");

        // Start TaterSync
        taterSync = new TaterSync("plugins", getLogger());
        taterSync.start();

        // Register event listener
        getServer().getPluginManager().registerEvents(new BukkitEventListener(), this);

        // Register commands
        Objects.requireNonNull(getCommand("tatersync")).setExecutor(new TestInvCommand());

        // Plugin enable message
        getLogger().info("TaterSync has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin disable message
        getLogger().info("TaterSync has been disabled!");
    }
}
