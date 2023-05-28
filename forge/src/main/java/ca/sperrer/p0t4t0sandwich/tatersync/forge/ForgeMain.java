package ca.sperrer.p0t4t0sandwich.tatersync.forge;

import ca.sperrer.p0t4t0sandwich.tatersync.common.TaterSync;
import ca.sperrer.p0t4t0sandwich.tatersync.forge.listeners.ForgeEventListener;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

import static ca.sperrer.p0t4t0sandwich.tatersync.common.Utils.*;

@Mod(ForgeMain.MODID)
public class ForgeMain {
    public TaterSync taterSync;
    public static final String MODID = "tatersync";
    public static final Logger logger = LogUtils.getLogger();

    // Get server type
    public String getServerType() {
        if (isMagma()) {
            return "Magma";
        } else if (isMohist()) {
            return "Mohist";
        } else if (isArclight()) {
            return "Arclight";
        } else {
            return "Forge";
        }
    }

    // Singleton instance
    private static ForgeMain instance;

    public static ForgeMain getInstance() {
        return instance;
    }


    public ForgeMain() {
        // Singleton instance
        instance = this;

        logger.info("[TaterSync]: TaterSync is running on " + getServerType() + ".");

        // Start TaterSync
        taterSync = new TaterSync("config", logger);
        taterSync.start();

        // Register event listener
        MinecraftForge.EVENT_BUS.register(new ForgeEventListener());

        // Mod enable message
        logger.info("[TaterSync]: TaterSync has been enabled!");
    }
}
