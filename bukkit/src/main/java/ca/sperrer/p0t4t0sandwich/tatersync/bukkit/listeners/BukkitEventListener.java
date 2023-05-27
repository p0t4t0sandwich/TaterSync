package ca.sperrer.p0t4t0sandwich.tatersync.bukkit.listeners;

import ca.sperrer.p0t4t0sandwich.tatersync.bukkit.BukkitMain;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static ca.sperrer.p0t4t0sandwich.tatersync.bukkit.BukkitUtils.mapPlayer;
import static ca.sperrer.p0t4t0sandwich.tatersync.common.Utils.runTaskAsync;

public class BukkitEventListener implements Listener {
    BukkitMain plugin = BukkitMain.getInstance();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        runTaskAsync(() -> {
            try {
                plugin.LPPronouns.pronounsData.refreshPronouns(mapPlayer(event.getPlayer()));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }
}
