package net.colosseum.pit.util;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InventoryUtil {

    public static int getItemInventoryIndex(Player player, Material material) {
        for (int i = 0; i < player.getInventory().getSize(); i++) {
            ItemStack item = player.getInventory().getItem(i);
            if (item != null && item.getType() == material) {
                return i;
            }
        }

        return -1;
    }
}
