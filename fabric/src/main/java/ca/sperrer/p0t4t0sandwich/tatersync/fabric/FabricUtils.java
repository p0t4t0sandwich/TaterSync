package ca.sperrer.p0t4t0sandwich.tatersync.fabric;

import ca.sperrer.p0t4t0sandwich.tatersync.common.PlayerInstance;
import net.minecraft.server.network.ServerPlayerEntity;

public class FabricUtils {
    /**
     * Maps a Fabric Player to a PlayerInstance.
     * @param player Fabric Player
     * @return PlayerInstance
     */
    public static PlayerInstance mapPlayer(ServerPlayerEntity player) {
        return new PlayerInstance(player.getEntityName(), player.getUuid());
    }
}
