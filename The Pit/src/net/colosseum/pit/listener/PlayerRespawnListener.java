package net.colosseum.pit.listener;

import net.colosseum.pit.Pit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener implements Listener {

    private Pit p;

    public PlayerRespawnListener(Pit p) {
        this.p = p;
    }

    @EventHandler
    public void onRespawnEvent(PlayerRespawnEvent e) {
        p.defaultSpawnItems(e.getPlayer());
    }
}
