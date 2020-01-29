package net.colosseum.pit.listener;

import net.colosseum.pit.Pit;
import net.colosseum.pit.data.PlayerData;
import net.colosseum.pit.perk.IPerk;
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
        PlayerData playerData = p.getPlayerDataManager().getPlayerData(e.getPlayer());
        for (Class<? extends IPerk> perkClass: PlayerData.PERKS) {
            IPerk perk = playerData.getPerk(perkClass);
            if (playerData.hasEnabledPerk(perkClass) && perk.getType() == PlayerRespawnEvent.class) {
                perk.handlePerk(e);
            }
        }
    }
}
