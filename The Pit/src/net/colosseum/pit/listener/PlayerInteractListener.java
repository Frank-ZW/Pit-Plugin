package net.colosseum.pit.listener;

import net.colosseum.pit.Pit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.Collection;

public class PlayerInteractListener implements Listener {

    private Pit p;

    public PlayerInteractListener(Pit p) {
        this.p = p;
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack item = player.getItemInHand();
            if (item != null && item.getType().equals(Material.SKULL_ITEM)) {
                int index = player.getInventory().getHeldItemSlot();
                int newAmount = item.getAmount() - 1;
                item.setAmount(newAmount);
                player.getInventory().setItem(index, newAmount <= 0 ? null : item);

                Collection<PotionEffect> effects = Arrays.asList(
                        new PotionEffect(PotionEffectType.ABSORPTION, 2 * 60 * 20, 0),
                        new PotionEffect(PotionEffectType.SPEED, 8 * 20, 0),
                        new PotionEffect(PotionEffectType.REGENERATION, 4 * 20, 1)
                );

                player.addPotionEffects(effects);
            }
        }
    }
}
