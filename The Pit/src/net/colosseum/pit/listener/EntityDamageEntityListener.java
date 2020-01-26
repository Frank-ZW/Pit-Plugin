package net.colosseum.pit.listener;

import net.colosseum.pit.Pit;
import net.colosseum.pit.data.PlayerData;
import net.colosseum.pit.perk.IPerk;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageEntityListener implements Listener {

    private Pit p;

    public EntityDamageEntityListener(Pit p) {
        this.p = p;
    }

    @EventHandler
    public void onEntityDamageEntityEvent(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player) && (!(e.getDamager() instanceof Player) || !(e.getDamager() instanceof Projectile))) {
            e.setCancelled(true);
        }

        PlayerData playerData = p.getPlayerDataManager().getPlayerData((Player) e.getDamager());
        if (playerData == null) {
            return;
        }

        for (Class<? extends IPerk> perkClass: PlayerData.PERKS) {
            IPerk perk = playerData.getPerk(perkClass);
            if (perk.isEnabled() && perk.getType() == EntityDamageByEntityEvent.class) {
                perk.handlePerk(e);
            }
        }
    }
}
