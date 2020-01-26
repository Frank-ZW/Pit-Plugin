package net.colosseum.pit.listener;

import net.colosseum.pit.Pit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockBreakPlaceListener implements Listener {

    Pit p;

    public BlockBreakPlaceListener(Pit p) {
        this.p = p;
    }

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent e) {
        e.setCancelled(true);
    }
}
