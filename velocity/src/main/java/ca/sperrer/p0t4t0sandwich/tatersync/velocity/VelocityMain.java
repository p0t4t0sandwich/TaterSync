package ca.sperrer.p0t4t0sandwich.tatersync.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;

@Plugin(
        id = "tatersync",
        name = "TaterSync",
        version = "1.0.0"
)
public class VelocityMain {
    @Inject
    private ProxyServer server;

    @Inject
    private Logger logger;

    // Get logger
    public Logger getLogger() {
        return this.logger;
    }

    // Get server type
    public String getServerType() {
        return "Velocity";
    }

    // Singleton instance
    private static VelocityMain instance;
    public static VelocityMain getInstance() {
        return instance;
    }

    public ProxyServer getServer() {
        return this.server;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        // Singleton instance
        instance = this;
        this.logger.info("Sorry, TaterSync isn't implemented for " + getServerType() + ".");
    }
}
