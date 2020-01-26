package net.colosseum.pit.perk.perks;

import net.colosseum.pit.Pit;
import net.colosseum.pit.data.PlayerData;
import net.colosseum.pit.perk.types.PlayerDeathPerk;
import net.colosseum.pit.util.InventoryUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class ScavengerPerk extends PlayerDeathPerk {

    public ScavengerPerk(Pit p, PlayerData playerData) {
        super(p, playerData);
    }

    /**
     * Player receives an arrow per kill and maxes out at 64.
     */
    @Override
    public void handlePerk(PlayerDeathEvent e) {
        Player player = e.getEntity().getKiller();
        int index = InventoryUtil.getItemInventoryIndex(player, Material.ARROW);
        if (index == -1) {
            player.getInventory().addItem(new ItemStack(Material.ARROW));
            return;
        }

        ItemStack arrows = player.getInventory().getItem(index);
        if (arrows.getAmount() >= 64) {
            return;
        }

        arrows.setAmount(arrows.getAmount() + 1);
        player.getInventory().setItem(index, arrows);
    }
}
