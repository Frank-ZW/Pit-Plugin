package net.colosseum.pit.listener;

import net.colosseum.pit.Pit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class SaturationListener implements Listener {

    private Pit p;

    public SaturationListener(Pit p) {
        this.p = p;
    }

    @EventHandler
    public void onFoodLevelEvent(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }
}
