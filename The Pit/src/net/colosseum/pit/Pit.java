package net.colosseum.pit;

import net.colosseum.pit.command.CommandHandler;
import net.colosseum.pit.command.commands.PerkCommand;
import net.colosseum.pit.command.commands.PrintPerkCommand;
import net.colosseum.pit.command.commands.StatCommand;
import net.colosseum.pit.listener.*;
import net.colosseum.pit.manager.PlayerDataManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class Pit extends JavaPlugin {

    private PlayerDataManager playerDataManager = new PlayerDataManager(this);

    @Override
    public void onEnable() {
        playerDataManager.logOnlinePlayers();

        registerEvents();
        registerCommands();
    }

    @Override
    public void onDisable() {}

    public PlayerDataManager getPlayerDataManager() {
        return this.playerDataManager;
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new JoinQuitListener(this), this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawnListener(this), this);
        getServer().getPluginManager().registerEvents(new SaturationListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockBreakPlaceListener(this), this);
        getServer().getPluginManager().registerEvents(new EntityDamageEntityListener(this), this);
    }

    private void registerCommands() {
        CommandHandler handler = new CommandHandler(this);
        handler.register("addperk", new PerkCommand());
        handler.register("printperks", new PrintPerkCommand());
        handler.register("get", new StatCommand());

        getCommand("pit").setExecutor(handler);
    }

    public void defaultSpawnItems(Player player) {
            ItemStack arrows = new ItemStack(Material.ARROW, 32);
            ItemStack ironSword = new ItemStack(Material.IRON_SWORD);
            ItemStack bow = new ItemStack(Material.BOW);
            player.getInventory().setItem(0, ironSword);
            player.getInventory().setItem(1, bow);
            player.getInventory().setItem(8, arrows);

            ItemStack[] armor = new ItemStack[4];
            armor[0] = new ItemStack(Material.IRON_BOOTS);
            armor[1] = new ItemStack(Material.IRON_LEGGINGS);
            armor[2] = new ItemStack(Material.IRON_CHESTPLATE);
            armor[3] = null;

            player.getInventory().setArmorContents(armor);
    }
}
