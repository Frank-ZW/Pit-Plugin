package net.colosseum.pit.listener;

import net.colosseum.pit.Pit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {

    private Pit p;

    public EntityDamageListener(Pit p) {
        this.p = p;
    }

    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent e) {
        if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL) && !p.getConfig().getBoolean("Fall-damage")) {
            e.setCancelled(true);
        }
    }
}
