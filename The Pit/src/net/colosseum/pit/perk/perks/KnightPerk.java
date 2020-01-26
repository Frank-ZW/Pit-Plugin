package net.colosseum.pit.perk.perks;

import net.colosseum.pit.Pit;
import net.colosseum.pit.data.PlayerData;
import net.colosseum.pit.perk.types.PlayerRespawnPerk;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class KnightPerk extends PlayerRespawnPerk {

    public KnightPerk(Pit p, PlayerData playerData) {
        super(p, playerData);
    }

    @Override
    public void handlePerk(PlayerRespawnEvent e) {
        Player player = e.getPlayer();
        ItemStack[] armor = player.getInventory().getArmorContents();
        armor[3] = new ItemStack(Material.CHAINMAIL_HELMET);
        player.getInventory().setArmorContents(armor);
    }
}
