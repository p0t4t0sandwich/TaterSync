package ca.sperrer.p0t4t0sandwich.tatersync.fabric;

import ca.sperrer.p0t4t0sandwich.tatersync.common.player.TaterPlayer;
import net.minecraft.server.network.ServerPlayerEntity;

public class FabricUtils {
    /**
     * Maps a Fabric Player to a TaterPlayer.
     * @param player Fabric Player
     * @return TaterPlayer
     */
    public static TaterPlayer mapPlayer(ServerPlayerEntity player) {
        return new TaterPlayer(player.getEntityName(), player.getUuid());
    }
}
