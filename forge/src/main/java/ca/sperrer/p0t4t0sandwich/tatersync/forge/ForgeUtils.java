package ca.sperrer.p0t4t0sandwich.tatersync.forge;

import ca.sperrer.p0t4t0sandwich.tatersync.common.player.TaterPlayer;
import net.minecraft.server.level.ServerPlayer;

public class ForgeUtils {
    /**
     * Maps a Forge Player to a TaterPlayer.
     * @param player Forge Player
     * @return TaterPlayer
     */
    public static TaterPlayer mapPlayer(ServerPlayer player) {
        return new TaterPlayer(player.getName().toString(), player.getUUID());
    }
}
