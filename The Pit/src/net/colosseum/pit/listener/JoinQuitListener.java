package net.colosseum.pit.listener;

import net.colosseum.pit.Pit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class JoinQuitListener implements Listener {

    private Pit p;

    public JoinQuitListener(Pit p) {
        this.p = p;
    }

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (!p.getPlayerDataManager().containsPlayer(player)) {
            p.defaultSpawnItems(player);
            p.getPlayerDataManager().addPlayer(player);
            return;
        }

        p.getPlayerDataManager().getPlayerData(player).setOnline(true);
    }

    @EventHandler
    public void onQuitEvent(PlayerQuitEvent e) {
        p.getPlayerDataManager().getPlayerData(e.getPlayer()).setOnline(false);
    }
}
