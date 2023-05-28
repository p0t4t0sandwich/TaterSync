package ca.sperrer.p0t4t0sandwich.tatersync.fabric;

import ca.sperrer.p0t4t0sandwich.tatersync.common.TaterSync;
import ca.sperrer.p0t4t0sandwich.tatersync.fabric.listeners.FabricEventListener;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FabricMain implements DedicatedServerModInitializer {
    public TaterSync taterSync;

    // Logger
    public final Logger logger = LoggerFactory.getLogger("tatersync");

    // Get server type
    public String getServerType() {
        return "Fabric";
    }

    // Singleton instance
    private static FabricMain instance;
    public static FabricMain getInstance() {
        return instance;
    }

    @Override
    public void onInitializeServer() {
        // Singleton instance
        instance = this;

        logger.info("[TaterSync]: TaterSync is running on " + getServerType() + ".");

        // Start TaterSync
        taterSync = new TaterSync("config", logger);
        taterSync.start();

        // Register event listeners
        ServerPlayConnectionEvents.JOIN.register(new FabricEventListener());

        // Mod enable message
        logger.info("[TaterSync]: TaterSync has been enabled!");
    }
}
