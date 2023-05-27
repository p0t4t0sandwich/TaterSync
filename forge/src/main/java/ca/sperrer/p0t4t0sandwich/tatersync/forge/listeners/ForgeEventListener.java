package ca.sperrer.p0t4t0sandwich.tatersync.forge.listeners;

import ca.sperrer.p0t4t0sandwich.tatersync.forge.ForgeMain;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static ca.sperrer.p0t4t0sandwich.tatersync.common.Utils.runTaskAsync;
import static ca.sperrer.p0t4t0sandwich.tatersync.forge.ForgeUtils.mapPlayer;

public class ForgeEventListener {
    ForgeMain mod = ForgeMain.getInstance();

    @SubscribeEvent
    public void onPlayerConnect(PlayerEvent.PlayerLoggedInEvent event) {
        runTaskAsync(() -> {
            try {
                mod.LPPronouns.pronounsData.refreshPronouns(mapPlayer((ServerPlayer) event.getEntity()));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }
}
