package ca.sperrer.p0t4t0sandwich.tatersync.bungee;

import net.md_5.bungee.api.plugin.Plugin;

public class BungeeMain extends Plugin {
    // Get server type
    public String getServerType() {
        return "BungeeCord";
    }

    // Singleton instance
    private static BungeeMain instance;
    public static BungeeMain getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        // Singleton instance
        instance = this;
        getLogger().info("Sorry, TaterSync isn't implemented for " + getServerType() + ".");
    }

    @Override
    public void onDisable() {
        // Plugin disable message
        getLogger().info("TaterSync has been disabled!");
    }
}
