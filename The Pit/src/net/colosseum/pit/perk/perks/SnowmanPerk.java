package net.colosseum.pit.perk.perks;

import net.colosseum.pit.Pit;
import net.colosseum.pit.data.PlayerData;
import net.colosseum.pit.perk.types.PlayerRespawnPerk;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class SnowmanPerk extends PlayerRespawnPerk {

    public SnowmanPerk(Pit p, PlayerData playerData) {
        super(p, playerData);
    }

    @Override
    public void handlePerk(PlayerRespawnEvent e) {
        e.getPlayer().getInventory().addItem(new ItemStack(Material.SNOW_BALL, 12));
    }
}
