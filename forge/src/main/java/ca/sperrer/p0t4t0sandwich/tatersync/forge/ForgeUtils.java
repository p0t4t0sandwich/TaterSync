package ca.sperrer.p0t4t0sandwich.tatersync.forge;

import ca.sperrer.p0t4t0sandwich.tatersync.common.PlayerInstance;
import net.minecraft.server.level.ServerPlayer;

public class ForgeUtils {
    /**
     * Maps a Forge Player to a PlayerInstance.
     * @param player Forge Player
     * @return PlayerInstance
     */
    public static PlayerInstance mapPlayer(ServerPlayer player) {
        return new PlayerInstance(player.getName().toString(), player.getUUID());
    }
}
