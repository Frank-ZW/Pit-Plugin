package net.colosseum.pit.command.commands;

import net.colosseum.pit.Pit;
import net.colosseum.pit.command.ICommand;
import net.colosseum.pit.data.PlayerData;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatCommand implements ICommand {

    @Override
    public boolean onCommand(Pit p, CommandSender commandSender, Command command, String[] args) {

        Player player = (Player) commandSender;
        PlayerData playerData = p.getPlayerDataManager().getPlayerData(player);
        if (args[1].equalsIgnoreCase("gold")) {
            player.sendMessage(ChatColor.BLUE + "Gold: " + playerData.getBalance());
            return true;
        }

        if (args[1].equalsIgnoreCase("killstreak")) {
            player.sendMessage(ChatColor.RED + "Killstreak: " + playerData.getKillStreak());
            return true;
        }

        if (args[1].equalsIgnoreCase("experience")) {
            player.sendMessage(ChatColor.GREEN + "XP: " + playerData.getXP());
            return true;
        }

        if (args[1].equalsIgnoreCase("prestige")) {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Prestige: " + playerData.getPrestige());
            return true;
        }

        player.sendMessage(ChatColor.RED + "This command does not exist!");
        return true;
    }
}
