package net.colosseum.pit.command.commands;

import net.colosseum.pit.Pit;
import net.colosseum.pit.command.ICommand;
import net.colosseum.pit.data.PlayerData;
import net.colosseum.pit.perk.perks.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DisablePerkCommand implements ICommand {

    @Override
    public boolean onCommand(Pit p, CommandSender commandSender, Command command, String[] args) {

        PlayerData playerData = p.getPlayerDataManager().getPlayerData((Player) commandSender);
        if (args[1].equalsIgnoreCase("ghead")) {
            playerData.disablePerk(GHeadPerk.class);
            return true;
        }

        if (args[1].equalsIgnoreCase("rod")) {
            playerData.disablePerk(FishingRodPerk.class);
            return true;
        }

        if (args[1].equalsIgnoreCase("knight")) {
            playerData.disablePerk(KnightPerk.class);
            return true;
        }

        if (args[1].equalsIgnoreCase("scavenger")) {
            playerData.disablePerk(ScavengerPerk.class);
            return true;
        }

        if (args[1].equalsIgnoreCase("snowman")) {
            playerData.disablePerk(SnowmanPerk.class);
            return true;
        }

        if (args[1].equalsIgnoreCase("counter")) {
            playerData.disablePerk(CounterPerk.class);
            return true;
        }

        if (args[1].equalsIgnoreCase("curse")) {
            playerData.disablePerk(CursePerk.class);
            return true;
        }

        if (args[1].equalsIgnoreCase("all")) {
            playerData.disableAllPerks();
            return true;
        }

        commandSender.sendMessage(ChatColor.RED + "This command does not exist!");
        return true;
    }
}
