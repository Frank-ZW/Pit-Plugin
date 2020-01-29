package net.colosseum.pit.perk.perks;

import net.colosseum.pit.Pit;
import net.colosseum.pit.data.PlayerData;
import net.colosseum.pit.perk.types.PlayerDeathPerk;
import net.colosseum.pit.util.InventoryUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class GHeadPerk extends PlayerDeathPerk {

    public GHeadPerk(Pit p, PlayerData playerData) {
        super(p, playerData);
    }

    @Override
    public void handlePerk(PlayerDeathEvent e) {
        Player player = e.getEntity().getKiller();
        PlayerData playerData = p.getPlayerDataManager().getPlayerData(player);
        if (playerData.hasEnabledPerk(CursePerk.class)) {
            return;
        }

        int index = InventoryUtil.getItemInventoryIndex(player, Material.SKULL_ITEM);
        if (index == -1) {
            ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
            SkullMeta meta = (SkullMeta) head.getItemMeta();
            meta.setOwner("LegendaryJulien");
            meta.setDisplayName(ChatColor.AQUA + "Golden Head");
            head.setItemMeta(meta);

            player.getInventory().addItem(head);
            return;
        }

        ItemStack oldHead = player.getInventory().getItem(index);
        if (oldHead.getAmount() >= 2) {
            return;
        }

        oldHead.setAmount(oldHead.getAmount() + 1);
        player.updateInventory();
    }
}
